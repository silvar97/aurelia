package com.discord.aurelia.command;

import com.discord.aurelia.repository.WarningRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import discord4j.common.util.Snowflake;
import discord4j.core.GatewayDiscordClient;
import discord4j.rest.util.Color;
import discord4j.core.event.domain.Event;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Member;
import org.springframework.stereotype.Component;

@Component
public class UserInfoCommand implements CommandInterface {

    @Autowired
    private WarningRepository warning;

    @Autowired
    private GatewayDiscordClient gateway;

    public void execute(Event event) {

        /*
         * Create object of MessageCreateEvent class
         */
        MessageCreateEvent msgCreateEvent = (MessageCreateEvent) event;

        final Member pingedUser;
       
        if (msgCreateEvent.getMessage().getContent().split(" ").length > 1) {

            /*
             * Define user who mentioned another user
             */
            String mentionedUser = msgCreateEvent.getMessage().getContent().replaceAll(" +", " ").split(" ")[1]
                    .replaceAll("[^0-9]", "");

            /*
             * Define user that GETS mentioned by another user
             */
            pingedUser = gateway.getMemberById(msgCreateEvent.getGuildId().get(), Snowflake.of(mentionedUser)).block();

        } else {
            pingedUser = msgCreateEvent.getMember().get();
        }
        
        String userHighestRoles = String.format("%s\n", pingedUser.getHighestRole().block().getName());
        String userOnlineStatus = String.format("%s\n", pingedUser.getPresence().block().getStatus());
        LocalDateTime userServerJoiningTime = LocalDateTime.ofInstant(pingedUser.getJoinTime(), ZoneId.systemDefault());
        DateTimeFormatter format = DateTimeFormatter.ofPattern("EEEE, MMM dd, yyyy HH:mm:ss a");
        LocalDateTime userDiscordJoiningTime = LocalDateTime.ofInstant(pingedUser.getId().getTimestamp(),
                ZoneId.systemDefault());

        msgCreateEvent.getMessage().getChannel().block().createEmbed(e -> {
            e.setColor(Color.of(224, 102, 102));
            e.setThumbnail(pingedUser.getAvatarUrl());
            e.addField("User Information for " + pingedUser.getTag(), "UserID: " + pingedUser.getId().asString(), true);
            e.addField("Highest Role on Server", userHighestRoles, true);
            e.addField("Server Violations", "Todo...", true);
            e.addField("Joined Server at", userServerJoiningTime.format(format), true);
            e.addField("Joined Discord at", userDiscordJoiningTime.format((format)), true);
            e.addField("Status", userOnlineStatus, true);
            Optional<Instant> instant = pingedUser.getPremiumTime();
            if (instant.isPresent()) {
                LocalDateTime time = LocalDateTime.ofInstant(instant.get(), ZoneId.systemDefault());
                e.addField("Boosting Since", time.format(format), true);
            } else {
                e.addField("Boosting Since", "Not boosting", true);
            }
            if (msgCreateEvent.getMessage().getContent().split(" ").length > 1){
                e.setFooter("Requested by " + msgCreateEvent.getMessage().getAuthor().get().getTag() + " | " + msgCreateEvent.getMessage().getAuthor().get().getId().asString(), msgCreateEvent.getMessage().getAuthor().get().getAvatarUrl());
            } else {
            e.setFooter("Requested by " + pingedUser.getTag() + " | " + pingedUser.getId().asString(), pingedUser.getAvatarUrl());
            }
        }).block();

    }
    
    @Override
    public String description() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
