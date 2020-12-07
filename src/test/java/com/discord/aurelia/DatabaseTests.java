package com.discord.aurelia;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import com.discord.aurelia.model.Auditlog;
import com.discord.aurelia.model.Ban;
import com.discord.aurelia.model.BanPK;
import com.discord.aurelia.model.DbGuild;
import com.discord.aurelia.model.DbUser;
import com.discord.aurelia.model.Setting;
import com.discord.aurelia.model.Warning;
import com.discord.aurelia.model.WarningPK;
import com.discord.aurelia.repository.AuditlogRepository;
import com.discord.aurelia.repository.BanRepository;
import com.discord.aurelia.repository.GuildRepository;
import com.discord.aurelia.repository.SettingRepository;
import com.discord.aurelia.repository.UserRepository;
import com.discord.aurelia.repository.WarningRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// {UserRepository.class,GuildRepository.class,
//     BanRepository.class,WarningRepository.class,SettingRepository.class}
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AureliaApplication.class)
public class DatabaseTests {

    @Autowired
    UserRepository userRepo;
    @Autowired
    GuildRepository guildRepo;
    @Autowired
    BanRepository banRepo;
    @Autowired
    WarningRepository warningRepo;
    @Autowired
    SettingRepository settingRepo;
    @Autowired
    AuditlogRepository auditRepo;

    @Test
    public void dbUserTest() {

        DbUser user = new DbUser(1l);
        userRepo.save(user);
        assertEquals(1, userRepo.count());
        userRepo.save(user);
        assertEquals(1, userRepo.count());
        userRepo.delete(user);
        assertEquals(0, userRepo.count());
    }

    @Test
    public void dbGuildTest() {
        DbUser user = new DbUser(2L);
        DbGuild guild = new DbGuild(2l);
        guild.setOwnerId(user);
        guildRepo.save(guild);
        assertEquals(1, guildRepo.count());
        guildRepo.delete(guild);
        userRepo.delete(user);
        assertEquals(0, guildRepo.count());
        assertEquals(0, userRepo.count());
    }

    @Test
    public void dbWarningTest() {
        DbUser owner = new DbUser(1l);
        DbUser warnedUser = new DbUser(2l);

        DbGuild guild = new DbGuild(owner.getId());
        Setting setting = new Setting(guild.getGuildId(), 3);
        guild.setSetting(setting);
        guild.setOwnerId(owner);
        setting.setDbGuild(guild);
        WarningPK warningPk = new WarningPK(guild.getGuildId(), warnedUser.getId());
        Warning warning = new Warning(warningPk);
        warning.setMaxWarnings(guild.getSetting().getMaxWarnings());
        warning.setDbGuild(guild);
        warning.setDbUser(warnedUser);

        warningRepo.save(warning);
        assertEquals(1, warningRepo.count());
        warningRepo.delete(warning);
        assertEquals(0, warningRepo.count());
        userRepo.delete(owner);
        userRepo.delete(warnedUser);
        guildRepo.delete(guild);
        assertEquals(0, userRepo.count());
    }

    @Test
    public void dbBanTest() {
        DbUser owner = new DbUser(1l);
        DbUser warnedUser = new DbUser(2l);

        DbGuild guild = new DbGuild(owner.getId());
        Setting setting = new Setting(guild.getGuildId(), 3);
        guild.setSetting(setting);
        guild.setOwnerId(owner);
        setting.setDbGuild(guild);
        BanPK banPk = new BanPK(warnedUser.getId(), guild.getGuildId());
        Ban ban = new Ban(banPk);
        ban.setDbGuild(guild);
        ban.setDbUser(warnedUser);
        ban.setBanTime(Date.from(Instant.now()));
        banRepo.save(ban);
        assertEquals(1, banRepo.count());
        banRepo.delete(ban);
        assertEquals(0, banRepo.count());
        userRepo.delete(owner);
        userRepo.delete(warnedUser);
        guildRepo.delete(guild);
        assertEquals(0, userRepo.count());
        assertEquals(0, guildRepo.count());

    }

    @Test
    public void auditLogTest() {

        DbUser owner = new DbUser(1l);
        DbGuild guild = new DbGuild(owner.getId());
        guild.setOwnerId(owner);
        Auditlog audit = new Auditlog(guild.getGuildId(), 123000l);
        audit.setDbGuild(guild);
        auditRepo.save(audit);
        assertEquals(1, auditRepo.count());
        auditRepo.delete(audit);
        assertEquals(0, auditRepo.count());
    }
}
