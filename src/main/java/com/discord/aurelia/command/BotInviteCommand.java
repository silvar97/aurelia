package com.discord.aurelia.command;

import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

import discord4j.rest.util.Color;
import reactor.core.publisher.Mono;
import discord4j.core.event.domain.Event;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;

@Component
public class BotInviteCommand implements CommandInterface {

    @Override
    public void execute(Event event) {
        
        /*
         * Create object of MessageCreateEvent class
         */
        MessageCreateEvent msgCreateEvent = (MessageCreateEvent) event;

        String userName = msgCreateEvent.getMember().get().getTag();

        Mono<Message> monoMsg = msgCreateEvent.getMessage().getChannel().block().createEmbed(e -> {
            e.setColor(Color.of(224, 102, 102));
            e.setDescription(
                    "I will send you all important links in your private messages.\n Make sure that your DMs are on.");
            e.setFooter("Requested by " + userName, msgCreateEvent.getMember().get().getAvatarUrl());
            e.setTimestamp(Instant.now());
        });
        Message msg = monoMsg.block();
        msgCreateEvent.getMessage().delete().block();
        msg.delete().delaySubscription(Duration.ofSeconds(5)).subscribe();

        msgCreateEvent.getMember().get().getPrivateChannel().block().createEmbed(p -> {
            p.setColor(Color.of(224, 102, 102));
            p.setDescription(
                    "[Invite Aurelia](https://discord.com/api/oauth2/authorize?client_id=760466273821392896&permissions=8&scope=bot) | [Need help with Aurelia?](https://discord.gg/sVDuvjrQtZ)");
        }).block();

    }

    @Override
    public String description() {
        // TODO Auto-generated method stub
        return "null";
    }
    
}
