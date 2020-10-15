package com.discord.aurelia.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.discord.aurelia.event.EmojiHandler;
import com.discord.aurelia.event.GuildHandler;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Order(1)
public class CommandCollection {

    private Map<String,Command<CommandInterface>> commands = new HashMap<>();

    public CommandCollection(){
        System.out.println("commandCollection");
    }

@PostConstruct
 public void init(){
      Command<CommandInterface> command = new Command<>("!ping",EmojiHandler.class);
      Command<CommandInterface> command1 = new Command<>("!guild",GuildHandler.class);
      addCommand(command);
      addCommand(command1);
 }

    public void addCommand(Command<CommandInterface> command) {
        commands.put(command.getCommand(),command);
    }

    public Map<String,Command<CommandInterface>> getCommands() {
        return commands;
    }

}
