package com.discord.aurelia.event;

import java.util.Optional;

import com.discord.aurelia.Service.GatewayService;
import com.discord.aurelia.Service.WarningService;
import com.discord.aurelia.command.CommandInterface;
import com.discord.aurelia.constant.CommandConstant;
import com.discord.aurelia.model.Setting;
import com.discord.aurelia.model.Warning;
import com.discord.aurelia.model.WarningKey;
import com.discord.aurelia.repository.BanRepository;
import com.discord.aurelia.repository.GuildRepository;
import com.discord.aurelia.repository.SettingRepo;
import com.discord.aurelia.repository.UserRepository;
import com.discord.aurelia.repository.WarningRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import discord4j.core.event.domain.Event;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Member;
import discord4j.rest.util.Permission;

@Component
@Order(1)
public class WarningHandler<T extends Event> implements CommandInterface {
    @Autowired
    private WarningRepository waringRepo;
    @Autowired
    private WarningService warningService;
    @Autowired
    private GatewayService gateway;
    @Autowired
    private BanRepository banRepo;
    @Autowired 
   private GuildRepository guildRepo; 
   @Autowired
   private UserRepository userRepo;
   @Autowired
   private SettingRepo settingRepo;
   @Autowired
   private CacheManager cache;

    @Override
    public void execute(Event event) {

        MessageCreateEvent msgEvent = (MessageCreateEvent) event;
        if (!msgEvent.getMessage().getContent().matches(CommandConstant.WARN_COMMAND_REGEX)) {
            return;
        }
        
       Long userId = Long.valueOf(msgEvent.getMessage().getContent().replaceAll(" +", " ").split(" ")[1].replaceAll("[^0-9]", ""));

       Optional<com.discord.aurelia.model.User> tmpUser = userRepo.findById(userId);
       WarningKey warningKey = new WarningKey(userId, msgEvent.getGuildId().get().asLong());
       Warning warning =warningService.get(warningKey);
       Optional<Setting> setting = settingRepo.findById(msgEvent.getGuildId().get().asLong());
        if(warning == null){
             warning= new Warning();
             warning.setCurrentWarnings(1);
             warning.setMaxWarnings(setting.isEmpty()?3:setting.get().getMaxWarnings());
             warning.setUser(new com.discord.aurelia.model.User(userId));
             warning.setGuild(new com.discord.aurelia.model.Guild(msgEvent.getGuildId().get().asLong()));
             warning.setWarningKey(warningKey);
            // warning.getUser().addWarning(warning);
            //userRepo.save(warning.getUser());
           // guildRepo.save(warning.getGuild());
             warningService.add(warning);
        }
        else {
            warning.setCurrentWarnings(warning.getCurrentWarnings()+1);
            if(warning.getCurrentWarnings() >= warning.getMaxWarnings()){
                //ban
                warningService.remove(warning);
            }
        }
    }

}
