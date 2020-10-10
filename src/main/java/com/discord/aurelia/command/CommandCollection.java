package com.discord.aurelia.command;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.discord.aurelia.event.MessageHandler;
import com.nimbusds.oauth2.sdk.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import discord4j.core.event.domain.Event;
import discord4j.core.event.domain.message.MessageEvent;

@Configuration
public class CommandCollection<T extends Event> {

    private Map<String, CommandInterface<T>> commands = new HashMap<>();
    @Autowired
    private ApplicationContext context;

    @Autowired
    private MessageHandler<MessageEvent> messageHandler;

    public CommandCollection(){
    System.out.println("commandcollection created");
    }

 @Bean
 public CommandCollection initCommandList(){
    Command<T> command = new Command("!ping", messageHandler);
    addCommand(command);
   return new CommandCollection<T>();

 }

    public void addCommand(Command<T> command) {
        commands.put(command.getCommand(), command.getEvent());
    }

    public Map<String, CommandInterface<T>> getCommands() {
        return Collections.unmodifiableMap(commands);
    }

}
