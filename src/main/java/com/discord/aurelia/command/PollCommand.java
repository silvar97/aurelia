package com.discord.aurelia.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

import discord4j.common.util.Snowflake;
import discord4j.core.GatewayDiscordClient;
import discord4j.rest.util.Color;
import discord4j.core.event.domain.Event;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Member;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.Role;
import discord4j.core.object.reaction.Reaction;
import discord4j.core.object.reaction.ReactionEmoji;

@Component
public class PollCommand implements CommandInterface {

    @Autowired
    private GatewayDiscordClient gateway;

    public void execute(Event event) {

        /*
         * Create object of MessageCreateEvent class
         */
        MessageCreateEvent msgCreateEvent = (MessageCreateEvent) event;

        /*
         * Check if message content is 2 or more
         */
        if (msgCreateEvent.getMessage().getContent().split(" ").length >= 2) {

            /*
             * Define content of user and split after command input
             */
            String content = msgCreateEvent.getMessage().getContent();
            String description = content.substring(content.indexOf(" ") + 1);

            /*
             * Check if role not empty
             */
            List<Role> list = msgCreateEvent.getMember().get().getRoles().collectList().block();
            if (list.size() == 0) {
                msgCreateEvent.getMessage().getChannel().block().createEmbed(e -> {
                    e.setColor(Color.of(224, 102, 102));
                    e.addField("Permission missing", "You need the `MANAGE_MESSAGES` permission to run this command.",
                            true);
                }).block();
                return;
            }

            /*
             * Delete user command input
             */
            msgCreateEvent.getMessage().delete().block();

            /*
             * Check for permissions
             */
            long permLongUser = list.get(0).getPermissions().getRawValue();
            boolean memberPermissionPresent = (permLongUser & 0x2000) == 0x2000;

            /*
             * Define time when message was created
             */
            LocalDateTime str = LocalDateTime.ofInstant(msgCreateEvent.getMessage().getTimestamp(),
                    ZoneId.systemDefault());
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

            if (memberPermissionPresent == true) {
                Message embedMessage = msgCreateEvent.getMessage().getChannel().block().createEmbed(e -> {
                    e.setColor(Color.of(224, 102, 102));
                    e.setAuthor("Poll of " + msgCreateEvent.getMember().get().getTag(), null,
                            msgCreateEvent.getMember().get().getAvatarUrl());
                    e.setDescription(description);
                    e.setFooter("Poll created: " + str.format(format), null);
                }).block();
                embedMessage.addReaction(ReactionEmoji.unicode("🟢")).block();
                embedMessage.addReaction(ReactionEmoji.unicode("🔴")).block();
                // message.addReaction(ReactionEmoji.custom(Snowflake.of(785153085793763358L),"Au_Yeet",
                // true)).block();

            } else {
                msgCreateEvent.getMessage().getChannel().block().createEmbed(e -> {
                    e.setColor(Color.of(224, 102, 102));
                    e.addField("Permission missing", "You need the `MANAGE_MESSAGES` permission to run this command.",
                            true);
                }).block();
            }
        } else {
            msgCreateEvent.getMessage().getChannel().block().createEmbed(e -> {
                e.setColor(Color.of(224, 102, 102));
                e.setDescription("Missing arguments.\n Check the syntax of the command with `!help poll`.");
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
