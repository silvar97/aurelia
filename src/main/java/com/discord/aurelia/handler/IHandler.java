package com.discord.aurelia.handler;

import discord4j.core.event.domain.Event;

public interface IHandler {
        public void handle(Event event);
        public String description();
}
