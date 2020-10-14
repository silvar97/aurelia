package com.discord.aurelia.command;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import discord4j.core.event.domain.Event;

@Component
@Order(1)
public class CommandCollection {

    private List<Command<Event>> commands = new ArrayList<>();

    @Autowired
    private CommandInterface<Event> messageHandler;
    @Autowired CommandInterface<Event> emojiHandler;

    public CommandCollection(){
        System.out.println("commandCollection");
    }

@PostConstruct
 public void init(){
    Command<Event> command = new Command<Event>("!ping", messageHandler);
    Command<Event> command1 = new Command<Event>("!emoji", emojiHandler);
    addCommand(command);
    addCommand(command1);
 }

    public void addCommand(Command<Event> command) {
        commands.add(command);
    }

    public List<Command<Event>> getCommands() {
        return commands;
    }

}
