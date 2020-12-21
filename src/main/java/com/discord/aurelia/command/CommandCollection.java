package com.discord.aurelia.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.discord.aurelia.event.BaningHandler;
import com.discord.aurelia.event.BotInvite;
import com.discord.aurelia.event.CommandDescriptionHandler;
import com.discord.aurelia.event.EmojiHandler;
import com.discord.aurelia.event.GuildHandler;
import com.discord.aurelia.event.KickHandler;
import com.discord.aurelia.event.MessageHandler;
import com.discord.aurelia.event.ReactionRoleAdding;
import com.discord.aurelia.event.ServerInfoHandler;
import com.discord.aurelia.event.UserAvatarDisplay;
import com.discord.aurelia.event.UserInfoHandler;
import com.discord.aurelia.event.VoiceChatHandler;
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
    private KickHandler<Event> kicking;

    @Autowired
    private ServerInfoHandler<Event> serverInfo;

    @Autowired
    private UserInfoHandler<Event> userInfo;

    @Autowired
    private BotInvite<Event> botInvite;

    @Autowired
    private UserAvatarDisplay<Event> userAvatarDisplay;

    @Autowired
    private ReactionRoleAdding<Event> reactionRoleAdding;

    @Autowired
    private CommandDescriptionHandler<Event> commandDescription;

@PostConstruct
 public void init(){
      Command<CommandInterface> command = new Command<>("!habib",EmojiHandler.class);
      Command<CommandInterface> command1 = new Command<>("!guild",GuildHandler.class);
      Command<CommandInterface> command2 = new Command<>("!emoji",emoji);
      Command<CommandInterface> warnCommand = new Command<>("!warn",warning);
      Command<CommandInterface> banCommand = new Command<>("!ban", baning);
      Command<CommandInterface> kickCommand = new Command<>("!kick", kicking);
      Command<CommandInterface> serverInfoCommand = new Command<>("!server-info", serverInfo);
      Command<CommandInterface> userInfoCommand = new Command<>("!user-info", userInfo);
      Command<CommandInterface> botInviteCommand = new Command<>("!invite", botInvite);
      Command<CommandInterface> voiceCommand = new Command<>("!join",voiceChatHandler);
      Command<CommandInterface> userAvatarDisplayCommand = new Command<>("!avatar", userAvatarDisplay);
      Command<CommandInterface> reactionRoleAddingCommand = new Command<>("!rr-add", reactionRoleAdding);
      Command<CommandInterface> commandDescriptionHandler = new Command<>("!test", commandDescription);

      addCommand(command);
      addCommand(command1);
      addCommand(command2);
      addCommand(warnCommand);
      addCommand(banCommand);
      addCommand(kickCommand);
      addCommand(serverInfoCommand);
      addCommand(userInfoCommand);
      addCommand(botInviteCommand);
      addCommand(voiceCommand);
      addCommand(userAvatarDisplayCommand);
      addCommand(reactionRoleAddingCommand);
      addCommand(commandDescriptionHandler);
 }

    public void addCommand(Command<CommandInterface> command) {
        commands.put(command.getCommand(),command);
    }

    public Map<String,Command<CommandInterface>> getCommands() {
        return commands;
    }

}
