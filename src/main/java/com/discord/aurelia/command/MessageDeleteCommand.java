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
public class MessageDeleteCommand implements CommandInterface {

    @Autowired
    private GatewayDiscordClient gateway;

    public void execute(Event event) {

        /*
         * Create object of MessageCreateEvent class
         */
        MessageCreateEvent msgCreateEvent = (MessageCreateEvent) event;

        




    }

    @Override
    public String description() {
        // TODO Auto-generated method stub
        return null;
    }
}