package com.discord.aurelia.event;

import com.discord.aurelia.command.CommandInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import discord4j.core.GatewayDiscordClient;
import discord4j.rest.util.Color;
import discord4j.rest.util.Image.Format;
import discord4j.core.event.domain.Event;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.channel.Channel.Type;
import discord4j.core.object.presence.Status;

@Component
public class UserInfoHandler<T extends Event> implements CommandInterface {

    @Autowired
    private GatewayDiscordClient gateway;

    public void execute(Event event) {

        /*
         * Create object of MessageCreateEvent class
         */
        MessageCreateEvent msgCreateEvent = (MessageCreateEvent) event;

        /*
         * Collect user information
         */
        String userName = msgCreateEvent.getMember().get().getTag();
        String userId = msgCreateEvent.getMember().get().getId().asString();
        String userHighestRoles = String.format("%s\n", msgCreateEvent.getMember().get().getHighestRole().block());
        String userViolations;
        String userServerJoiningTime = String.format("%s\n", msgCreateEvent.getMember().get().getJoinTime());
        String userDiscordJoiningTime;
        String userOnlineStatus = String.format("%s\n", msgCreateEvent.getMember().get().getPresence().block().getStatus());
        String userBoostingTime = String.format("%s\n", msgCreateEvent.getMember().get().getPremiumTime());

        /*
         * Create embed and insert user information
         */
        if (msgCreateEvent.getMessage().getContent().equals("!user-info")) {
            msgCreateEvent.getMessage().getChannel().block().createEmbed(e -> {
                e.setColor(Color.DARK_GRAY);
                e.setThumbnail(msgCreateEvent.getMember().get().getAvatarUrl());
                e.addField("User Information for" + userName, "UserID: " + userId, true);
                e.addField("User Highest Role", userHighestRoles, true);
                e.addField("Server Violations", "Todo...", true);
                e.addField("Joined Server at", userServerJoiningTime, true);
                e.addField("Joined Discord at", "Todo...", true);
                e.addField("Online Status", userOnlineStatus, true);
                e.addField("Boosting Since", userBoostingTime, true);
                e.setFooter("Requested by " + userName + " | " + userId, null);
                return;
            }).block();
        }
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return null;
    }

}