package com.discord.aurelia.command;

import discord4j.core.event.domain.Event;

public interface CommandInterface<T extends Event> {
    
    public void execute(T event);
}
