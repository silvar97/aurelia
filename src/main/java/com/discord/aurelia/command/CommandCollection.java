package com.discord.aurelia.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.discord.aurelia.event.EmojiHandler;
import com.discord.aurelia.event.GuildHandler;
import com.discord.aurelia.event.MessageHandler;
import com.nimbusds.oauth2.sdk.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import discord4j.core.event.domain.guild.EmojisUpdateEvent;
import discord4j.core.event.domain.message.MessageEvent;


@Component
@Order(1)
public class CommandCollection {

    private Map<String,Command<CommandInterface>> commands = new HashMap<>();
    @Autowired
    private EmojiHandler<EmojisUpdateEvent> emoji;
    public CommandCollection(){
        System.out.println("commandCollection");
    }

@PostConstruct
 public void init(){
<<<<<<< HEAD
     System.out.println(messageHandler.toString());
    Command<Event> command = new Command("!test", messageHandler);
    addCommand(command);
=======
      Command<CommandInterface> command = new Command<>("!ping",EmojiHandler.class);
      Command<CommandInterface> command1 = new Command<>("!guild",GuildHandler.class);
      Command<CommandInterface> command2 = new Command<>("!emoji",emoji);
      addCommand(command);
      addCommand(command1);
      addCommand(command2);
>>>>>>> 9d5468d57d3be4f98decee5deb5486f7268c85e1
 }

    public void addCommand(Command<CommandInterface> command) {
        commands.put(command.getCommand(),command);
    }

    public Map<String,Command<CommandInterface>> getCommands() {
        return commands;
    }

}
