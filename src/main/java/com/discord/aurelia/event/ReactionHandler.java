package com.discord.aurelia.event;

import com.discord.aurelia.command.CommandInterface;

import discord4j.core.event.domain.Event;

public class ReactionHandler implements CommandInterface {

    @Override
    public void execute(Event event) {

    }

    @Override
    public String description() {
        return "null";
    }
    
}
