

package com.discord.aurelia.event;

import org.springframework.core.GenericTypeResolver;
import org.springframework.stereotype.Component;

import discord4j.core.event.domain.Event;
import discord4j.core.event.domain.guild.EmojisUpdateEvent;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.event.domain.message.MessageEvent;

@Component
public class EmojiHandler<T extends Event> implements EventListenerInterface<T>{

    @Override
    @SuppressWarnings("unchecked")
    public Class<T> getEventType() {
        return (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), EmojiHandler.class);
    }

    @Override
    public void execute(T event) {
        hookOnEvent(event);
    }
    public final void  hookOnEvent(Event event) {
         if (event instanceof EmojisUpdateEvent)
         onEmojisUpdate((EmojisUpdateEvent) event);
    }
    private void onEmojisUpdate(EmojisUpdateEvent event) {
       
    }

  
}