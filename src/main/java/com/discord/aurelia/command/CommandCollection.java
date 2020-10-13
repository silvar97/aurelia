package com.discord.aurelia.command;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.discord.aurelia.event.MessageHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import discord4j.core.event.domain.Event;
import discord4j.core.event.domain.message.MessageEvent;

@Configuration
public class CommandCollection {

    private List<Command<Event>> commands = new ArrayList<>();

    @Autowired
    private CommandInterface<MessageEvent> messageHandler;

    public CommandCollection(){
        System.out.println("commandCollection");
    }

@PostConstruct
 public void init(){
     System.out.println(messageHandler.toString());
    Command<Event> command = new Command("!test", messageHandler);
    addCommand(command);
 }

    public void addCommand(Command<Event> command) {
        commands.add(command);
    }

    public List<Command<Event>> getCommands() {
        return commands;
    }

}
