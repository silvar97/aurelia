

package com.discord.aurelia.event;

import org.springframework.core.GenericTypeResolver;
import org.springframework.stereotype.Component;

import discord4j.core.event.domain.Event;
import discord4j.core.event.domain.guild.EmojisUpdateEvent;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.event.domain.message.MessageEvent;

@Component
public class EmojiHandler<T extends EmojisUpdateEvent>{

        public void handle(EmojisUpdateEvent event){
            
        }

  
}