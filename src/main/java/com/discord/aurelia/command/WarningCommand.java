package com.discord.aurelia.command;

import discord4j.core.event.domain.Event;
import discord4j.rest.util.Color;
import discord4j.rest.util.Permission;

import org.springframework.stereotype.Component;

@Component
public class WarningCommand implements CommandInterface {

    @Override
    public void execute(Event event) {
        // TODO Auto-generated method stub
      Permission p = new Permissions();
    }

    @Override
    public String description() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
