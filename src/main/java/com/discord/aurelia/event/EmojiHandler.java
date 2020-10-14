

package com.discord.aurelia.event;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import discord4j.core.event.domain.guild.EmojisUpdateEvent;

@Component
@Order(1)
public class EmojiHandler<T extends EmojisUpdateEvent>{

        public void handle(EmojisUpdateEvent event){
            
        }

  
}