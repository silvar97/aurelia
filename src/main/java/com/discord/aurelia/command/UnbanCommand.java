package com.discord.aurelia.command;

import org.springframework.beans.factory.annotation.Autowired;
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

@Component
public class UnbanCommand implements CommandInterface {

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
                    e.setColor(Color.of(224, 102, 102));
                    e.addField("Permission missing", "You need the `BAN_MEMBERS` permission to run this command.",
                            true);
                }).block();
                return;
            }

            long permLongUser = list.get(0).getPermissions().getRawValue();
            boolean memberPermissionPresent = (permLongUser & 4) == 4;

            if (memberPermissionPresent == true) {
                pingedUser.unban().block();
                msgCreateEvent.getMessage().getChannel().block().createEmbed(e -> {
                    e.setColor(Color.GREEN);
                    e.setAuthor(pingedUser.getTag() + " has been unbanned", pingedUser.getDefaultAvatarUrl(),
                            pingedUser.getAvatarUrl());
                }).block();
            } else {
                msgCreateEvent.getMessage().getChannel().block().createEmbed(e -> {
                    e.setColor(Color.of(224, 102, 102));
                    e.addField("Permission missing", "You need the `BAN_MEMBERS` permission to run this command.",
                            true);
                }).block();
            }
        } else {
            msgCreateEvent.getMessage().getChannel().block().createEmbed(e -> {
                e.setColor(Color.of(224, 102, 102));
                e.setDescription("Missing arguments.\n Check the syntax of the command with `!help unban`.");
                e.setFooter("Requested by " + msgCreateEvent.getMember().get().getTag(),
                        msgCreateEvent.getMember().get().getAvatarUrl());
                e.setTimestamp(Instant.now());
            }).block();
        }
    }

    @Override
    public String description() {
        // TODO Auto-generated method stub
        return null;
    }

}
