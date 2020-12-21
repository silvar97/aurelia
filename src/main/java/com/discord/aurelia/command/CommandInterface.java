package com.discord.aurelia.command;

import discord4j.core.event.domain.Event;

public interface CommandInterface {
    
    public void execute(Event event);
    public String description();
}

