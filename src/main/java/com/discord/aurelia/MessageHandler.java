package com.discord.aurelia;

import org.springframework.stereotype.Component;

import discord4j.core.event.domain.message.MessageCreateEvent;

@Component
public class MessageHandler {
    
    
    public MessageHandler(){
        System.out.println("Message handler created");
    }

    public void messageCreated(MessageCreateEvent event){
            event.getMessage().getChannel().block().createMessage("hallo noob").block();
    }

}
