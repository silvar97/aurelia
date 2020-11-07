package com.discord.aurelia.event;

import com.discord.aurelia.command.CommandInterface;
import com.discord.aurelia.repository.WarningRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import discord4j.common.util.Snowflake;
import discord4j.core.GatewayDiscordClient;
import discord4j.rest.util.Color;
import discord4j.rest.util.Image.Format;
import discord4j.core.event.domain.Event;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Member;
import discord4j.core.object.entity.Role;
import discord4j.core.object.entity.channel.Channel.Type;
import discord4j.core.object.presence.Status;

@Component
public class BotInvite<T extends Event> implements CommandInterface {

    @Autowired
    private GatewayDiscordClient gateway;

    public void execute(Event event) {

        /*
         * Create object of MessageCreateEvent class
         */
        MessageCreateEvent msgCreateEvent = (MessageCreateEvent) event;

        String userName = msgCreateEvent.getMember().get().getTag();
        //String botLink = https://discord.com/api/oauth2/authorize?client_id=760466273821392896&permissions=8&scope=bot
        String botLink = String.format("%s\n", "https://discord.com/api/oauth2/authorize?client_id=760466273821392896&permissions=8&scope=bot");

        if (msgCreateEvent.getMessage().getContent().equals("!invite")) {
            msgCreateEvent.getMessage().getChannel().block().createEmbed(e -> {
                e.setColor(Color.DARK_GRAY);
                e.setDescription(
                        "I will send you all important links in your private messages.\n Make sure that your DMs are on.");
                e.setFooter("Requested by " + userName, msgCreateEvent.getMember().get().getAvatarUrl());
                e.setTimestamp(Instant.now()); 
            }).block();
            msgCreateEvent.getMember().get().getPrivateChannel().block().createEmbed(p -> {
                p.setColor(Color.DARK_GRAY);
                p.addField("Bot Invite", botLink, true);
                p.addField("Support Server: ", "https://discord.gg/sVDuvjrQtZ", true);
            }).block();
        }
    }
    
    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return null;
    }

}