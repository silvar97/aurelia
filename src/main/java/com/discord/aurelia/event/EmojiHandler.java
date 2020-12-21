

package com.discord.aurelia.event;

import com.discord.aurelia.command.CommandInterface;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import discord4j.core.event.domain.Event;
import discord4j.core.event.domain.guild.EmojisUpdateEvent;

@Component
@Order(1)
public class EmojiHandler<T extends EmojisUpdateEvent> implements CommandInterface {

        public void handle(EmojisUpdateEvent event) {

        }

        @Override
        public void execute(Event event) {
                System.out.println("emojiHandler richtig");

        }

        @Override
<<<<<<< HEAD
        public String getDescription() {
                // TODO Auto-generated method stub
                return null;
=======
        public String description() {
                // TODO Auto-generated method stub
                return "null";
>>>>>>> 0d5f21e072f08b2ded6de9a93a4adbd9975be18c
        }

  
}