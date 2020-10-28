package com.discord.aurelia.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.discord.aurelia.event.BaningHandler;
import com.discord.aurelia.event.EmojiHandler;
import com.discord.aurelia.event.GuildHandler;
import com.discord.aurelia.event.MessageHandler;
<<<<<<< HEAD
import com.discord.aurelia.event.ServerInfoHandler;
=======
import com.discord.aurelia.event.VoiceChatHandler;
>>>>>>> 07507ac13f9bf5b6fefd3d26f51d46ad136e4bf9
import com.discord.aurelia.event.WarningHandler;
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

    public CommandCollection(){
        System.out.println("commandCollection");
    }
    @Autowired
    private BaningHandler<Event> baning;

    @Autowired
    private ServerInfoHandler<Event> serverInfo;

@PostConstruct
 public void init(){
      Command<CommandInterface> command = new Command<>("!habib",EmojiHandler.class);
      Command<CommandInterface> command1 = new Command<>("!guild",GuildHandler.class);
      Command<CommandInterface> command2 = new Command<>("!emoji",emoji);
      Command<CommandInterface> warnCommand = new Command<>("!warn",warning);
<<<<<<< HEAD
      Command<CommandInterface> banCommand = new Command<>("!ban", baning);
      Command<CommandInterface> serverInfoCommand = new Command<>("!server", serverInfo);

=======
      Command<CommandInterface> voiceCommand = new Command<>("!join",voiceChatHandler);
>>>>>>> 07507ac13f9bf5b6fefd3d26f51d46ad136e4bf9
      addCommand(command);
      addCommand(command1);
      addCommand(command2);
      addCommand(warnCommand);
<<<<<<< HEAD
      addCommand(banCommand);
      addCommand(serverInfoCommand);
=======
      addCommand(voiceCommand);
>>>>>>> 07507ac13f9bf5b6fefd3d26f51d46ad136e4bf9
 }

    public void addCommand(Command<CommandInterface> command) {
        commands.put(command.getCommand(),command);
    }

    public Map<String,Command<CommandInterface>> getCommands() {
        return commands;
    }

}
