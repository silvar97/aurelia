package com.discord.aurelia.event;

import com.discord.aurelia.command.CommandInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.Event;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.event.domain.message.ReactionAddEvent;
import discord4j.core.event.domain.message.ReactionRemoveEvent;
import discord4j.core.event.domain.role.RoleCreateEvent;
import discord4j.core.object.reaction.ReactionEmoji;
import discord4j.rest.util.Color;

@Component
public class CommandDescriptionHandler<T extends Event> implements CommandInterface {

    @Autowired
    private GatewayDiscordClient gateway;

    public void execute(Event event) {

        /*
         * Check which Event appears and create object
         */

         //MIT GETMESSAGE LÄSST SICH DIE MESSAGE ALLEIN AUCH EDITIEREN

        if (event instanceof MessageCreateEvent) {
            MessageCreateEvent msgCreateEvent = (MessageCreateEvent) event;
            msgCreateEvent.getMessage().getChannel().block().createEmbed(e -> {
                e.setColor(Color.of(224, 102, 102));
                e.setDescription("Habib ist...");
            }).block();
            msgCreateEvent.getMessage().getChannel().block().getLastMessage().block()
                    .addReaction(ReactionEmoji.unicode("1️⃣")).block();
        }
        if (event instanceof ReactionAddEvent) {
            ReactionAddEvent reactionAddEvent = (ReactionAddEvent) event;
            if (!reactionAddEvent.getMember().get().isBot()) {
                // reactionAddEvent.getChannel().block().getLastMessage().block()
                //         .removeSelfReaction((ReactionEmoji.unicode("1️⃣"))).block();
                reactionAddEvent.getMessage().block().edit(e -> {
                    e.setEmbed(m -> {
                        m.setColor(Color.VIVID_VIOLET);
                        m.setDescription("...ein Noob.");
                    });
                }).block();
            }
        }
        if (event instanceof ReactionRemoveEvent) {
            ReactionRemoveEvent reactionRemoveEvent = (ReactionRemoveEvent) event;
            reactionRemoveEvent.getMessage().block().edit(e -> {
                e.setEmbed(m -> {
                    m.setColor(Color.of(224, 102, 102));
                    m.setDescription("Habib ist...");
                });
            }).block();
        }
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return null;
    }

}