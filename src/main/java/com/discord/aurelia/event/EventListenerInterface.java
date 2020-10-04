package com.discord.aurelia.event;

import discord4j.core.event.domain.Event;

public interface EventListenerInterface<T extends Event> {
    
    Class<T> getEventType();
    void execute(T event);

}
