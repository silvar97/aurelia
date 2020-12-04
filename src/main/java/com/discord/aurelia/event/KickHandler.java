package com.discord.aurelia.event;

import com.discord.aurelia.command.CommandInterface;
import com.discord.aurelia.constant.CommandConstant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

import discord4j.common.util.Snowflake;
import discord4j.core.GatewayDiscordClient;
import discord4j.rest.util.Color;
import discord4j.core.event.domain.Event;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Member;
import discord4j.core.object.entity.Role;
import discord4j.core.object.entity.User;

@Component
public class KickHandler<T extends Event> implements CommandInterface {

    @Autowired
    private GatewayDiscordClient gateway;

    public void execute(Event event) {

        /*
         * Create object of MessageCreateEvent class
         */
        MessageCreateEvent msgCreateEvent = (MessageCreateEvent) event;

        final Member pingedUser;

        /*
         * Check if mentioned member is empty
         */
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
            
            /*
             * Check if role not empty
             */
            List<Role> list = msgCreateEvent.getMember().get().getRoles().collectList().block();
            if (list.size() == 0) {
                msgCreateEvent.getMessage().getChannel().block().createEmbed(e -> {
                    e.setColor(Color.GRAY);
                    e.addField("Permission missing", "You need the `KICK_MEMBERS` permission to run this command.",
                            true);
                }).block();
                return;
            }

            long permLongUser = list.get(0).getPermissions().getRawValue();
            boolean memberPermissionPresent = (permLongUser & 2) == 2;

            String moderator = String.format("%s", msgCreateEvent.getMessage().getAuthor().get().getTag());

            if (memberPermissionPresent == true) {
                pingedUser.getPrivateChannel().block().createEmbed(p -> {
                    p.setColor(Color.DARK_GRAY);
                    p.addField("You got kicked from:", msgCreateEvent.getGuild().block().getName(), false);
                    p.addField("Moderator that executed command: ", moderator, false);
                    p.addField("Reason: ", "Todo...", true);
                }).block();
                pingedUser.kick().block();
                msgCreateEvent.getMessage().getChannel().block().createEmbed(e -> {
                    e.setColor(Color.YELLOW);
                    e.setAuthor(pingedUser.getTag() + " has been kicked", pingedUser.getDefaultAvatarUrl(),
                            pingedUser.getAvatarUrl());
                    e.addField("Reason: ", "Todo...", false);
                    e.setFooter("Kicked by Moderator: " + msgCreateEvent.getMember().get().getTag(), null);
                    e.setTimestamp(Instant.now());
                }).block();
            } else {
                msgCreateEvent.getMessage().getChannel().block().createEmbed(e -> {
                    e.setColor(Color.GRAY);
                    e.addField("Permission missing", "You need the `KICK_MEMBERS` permission to run this command.",
                            true);
                }).block();
            }
        } else {
            msgCreateEvent.getMessage().getChannel().block().createEmbed(e -> {
                e.setColor(Color.RED);
                e.setDescription("Missing arguments.\n Check the syntax of the command with `!help kick`.");
                e.setFooter("Requested by " + msgCreateEvent.getMember().get().getTag(),
                        msgCreateEvent.getMember().get().getAvatarUrl());
                e.setTimestamp(Instant.now());
            }).block();
        }
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return "Kicks a User from the Server.\n !kick <user:mention/ID> (reason)";
    }

}