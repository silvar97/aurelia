package com.discord.aurelia.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.discord.aurelia.handler.EmojiHandler;
import com.discord.aurelia.handler.GuildHandler;
import com.discord.aurelia.handler.MessageHandler;
import com.discord.aurelia.handler.VoiceChatHandler;
import com.discord.aurelia.handler.WarningHandler;
import com.nimbusds.oauth2.sdk.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import discord4j.core.event.domain.Event;
import discord4j.core.event.domain.guild.EmojisUpdateEvent;
import discord4j.core.event.domain.message.MessageEvent;


@Component
@Order(1)
public class CommandCollection {

    private Map<String,Command<CommandInterface>> commands = new HashMap<>();
    @Autowired
    private EmojiHandler<EmojisUpdateEvent> emoji;
    @Autowired
    private WarningHandler<Event> warning;
    @Autowired
    private VoiceChatHandler<Event> voiceChatHandler;
    // @Autowired
    // private CommandDescriptionHandler cmdDescript;

    public CommandCollection(){
        System.out.println("commandCollection");
    }

@PostConstruct
 public void init(){
      Command<CommandInterface> command = new Command<>("!ping",EmojiHandler.class);
      Command<CommandInterface> command1 = new Command<>("!guild",GuildHandler.class);
      Command<CommandInterface> command2 = new Command<>("!emoji",emoji);
      Command<CommandInterface> warnCommand = new Command<>("!warn",warning);
      Command<CommandInterface> voiceCommand = new Command<>("!join",voiceChatHandler);
    //   Command<CommandInterface> commandHelper= new Command<>("!test",cmdDescript);
      addCommand(command);
      addCommand(command1);
      addCommand(command2);
      addCommand(warnCommand);
      addCommand(voiceCommand);
    //   addCommand(commandHelper);
 }

    public void addCommand(Command<CommandInterface> command) {
        commands.put(command.getCommand(),command);
    }

    public Map<String,Command<CommandInterface>> getCommands() {
        return commands;
    }

}
