package com.discord.aurelia;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
@Configuration
public class Config {
    

    @Bean
    public GatewayDiscordClient aureliaBot(){
        final String token = "NzYwNDY2MjczODIxMzkyODk2.X3MdaA.btlY8WQpwoB35mnziSNKj7kbg7g";
        final DiscordClient client = DiscordClient.create(token);
        final GatewayDiscordClient gateway = client.login().block();
        EventListener<MessageCreateEvent> listener = new CustomListener<>();
		gateway.getEventDispatcher().on(listener.getEventType()).subscribe(listener::execute);
        gateway.onDisconnect().block();
        
        return gateway;
    }



}
