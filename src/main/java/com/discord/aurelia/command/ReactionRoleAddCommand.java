package com.discord.aurelia.command;

import discord4j.core.event.domain.Event;
import org.springframework.stereotype.Component;

@Component
public class ReactionRoleAddCommand implements CommandInterface {

    @Override
    public void execute(Event event) {

    }

    @Override
    public String description() {
        return "null";
    }
    
}