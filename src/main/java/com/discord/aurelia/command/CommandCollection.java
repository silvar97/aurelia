package com.discord.aurelia.command;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.discord.aurelia.handler.VoiceChatHandler;
import com.discord.aurelia.handler.WarningHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import discord4j.core.event.domain.Event;

@Component
@Order(1)
public class CommandCollection {

    private Map<String, Command<CommandInterface>> commands = new HashMap<>();

    @Autowired
    private WarningHandler<Event> warning;
    @Autowired
    private VoiceChatHandler<Event> voiceChatHandler;
    // @Autowired
    // private CommandDescriptionHandler cmdDescript;

    public CommandCollection() {
        System.out.println("commandCollection");
    }

    @Autowired
    private BanCommand baning;

    @Autowired
    private KickCommand kicking;

    @Autowired
    private ServerInfoCommand serverInfo;

    @Autowired
    private UserInfoCommand userInfo;

    @Autowired
    private BotInviteCommand botInvite;

    @Autowired
    private UserAvatarCommand userAvatarDisplay;

    @Autowired
    private ReactionRoleAddCommand reactionRoleAdding;

    @Autowired
    private PollCommand pollVote;

    @Autowired
    private MuteCommand userMute;

    @Autowired
    private UnbanCommand unbaning;
    @PostConstruct
    public void init() {
        Command<CommandInterface> warnCommand = new Command<>("!warn", warning);
        Command<CommandInterface> banCommand = new Command<>("!ban", baning);
        Command<CommandInterface> unbanCommand = new Command<>("!unban", unbaning);
        Command<CommandInterface> kickCommand = new Command<>("!kick", kicking);
        Command<CommandInterface> serverInfoCommand = new Command<>("!server-info", serverInfo);
        Command<CommandInterface> userInfoCommand = new Command<>("!user-info", userInfo);
        Command<CommandInterface> botInviteCommand = new Command<>("!invite", botInvite);
        Command<CommandInterface> voiceCommand = new Command<>("!join", voiceChatHandler);
        Command<CommandInterface> userAvatarDisplayCommand = new Command<>("!avatar", userAvatarDisplay);
        Command<CommandInterface> reactionRoleAddingCommand = new Command<>("!rr-add", reactionRoleAdding);
        Command<CommandInterface> pollCommand = new Command<>("!poll", pollVote);
        Command<CommandInterface> muteCommand = new Command<>("!mute", userMute);
        
        // Command<CommandInterface> commandHelper= new Command<>("!test",cmdDescript);

        // Command<CommandInterface> commandHelper= new Command<>("!test",cmdDescript);
        addCommand(warnCommand);
        addCommand(banCommand);
        addCommand(unbanCommand);
        addCommand(kickCommand);
        addCommand(serverInfoCommand);
        addCommand(userInfoCommand);
        addCommand(botInviteCommand);
        addCommand(voiceCommand);
        addCommand(userAvatarDisplayCommand);
        addCommand(reactionRoleAddingCommand);
        addCommand(pollCommand);
        addCommand(muteCommand);
        // addCommand(commandHelper);
        // addCommand(commandHelper);
    }

    public void addCommand(Command<CommandInterface> command) {
        commands.put(command.getCommand(), command);
    }

    public Map<String, Command<CommandInterface>> getCommands() {
        return commands;
    }

}
