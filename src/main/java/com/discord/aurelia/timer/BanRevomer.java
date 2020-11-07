package com.discord.aurelia.timer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.TimerTask;

import com.discord.aurelia.Service.GatewayService;
import com.discord.aurelia.model.Ban;
import com.discord.aurelia.repository.BanRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import discord4j.common.util.Snowflake;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.object.entity.Guild;
import discord4j.core.object.entity.Member;
import discord4j.discordjson.json.gateway.InviteCreate;



@Component
@Lazy
public class BanRevomer  {


    @Autowired
    private BanRepository banRepo;
    @Autowired
    private GatewayService gateway;

//@Scheduled(fixedDelay = 10000)
public void removeBans(){
//    Iterable<Ban> bans = banRepo.findAll();
//    bans.forEach(b -> {
//        if(b.getBanTime().isBefore(LocalDateTime.now())== true){
//            try {
//
//                Member mem= gateway.getMemberById(Snowflake.of(b.getGuild().getGuildId()), Snowflake.of(b.getUser().getId())).block();
//                Guild guild = gateway.getGuildById(Snowflake.of(b.getGuild().getGuildId())).block();
//                mem.unban().block();
//                InviteCreate inv  = InviteCreate.builder().guildId(String.valueOf(b.getGuild().getGuildId())).build();
//                mem.getPrivateChannel().block().createMessage(inv.toString()).block();
//            }catch(Exception e ){
//                banRepo.delete(b);
//            }
//        }
//    });

}
    
    
}
