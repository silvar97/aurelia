package com.discord.aurelia.command;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

<<<<<<< HEAD
=======
import com.discord.aurelia.handler.EmojiHandler;
>>>>>>> 859468a60779971fb06626698f7065fc968b61b5
import com.discord.aurelia.handler.VoiceChatHandler;
import com.discord.aurelia.handler.WarningHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import discord4j.core.event.domain.Event;
<<<<<<< HEAD
=======
import discord4j.core.event.domain.guild.EmojisUpdateEvent;

>>>>>>> 859468a60779971fb06626698f7065fc968b61b5

@Component
@Order(1)
public class CommandCollection {

<<<<<<< HEAD
    private Map<String, Command<CommandInterface>> commands = new HashMap<>();

=======
    private Map<String,Command> commands = new HashMap<>();
    @Autowired
    private EmojiHandler<EmojisUpdateEvent> emoji;
>>>>>>> 859468a60779971fb06626698f7065fc968b61b5
    @Autowired
    private WarningHandler<Event> warning;
    @Autowired
    private VoiceChatHandler<Event> voiceChatHandler;
    @Autowired
    private WarningCommand warningCommand;
    // @Autowired
    // private CommandDescriptionHandler cmdDescript;

    public CommandCollection() {
        System.out.println("commandCollection");
    }

<<<<<<< HEAD
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
=======
@PostConstruct
 public void init(){
      Command command2 = new Command("!emoji",emoji);
      Command warnCommand = new Command("!warn",warningCommand);
      Command voiceCommand = new Command("!join",voiceChatHandler);
    //   Command<CommandInterface> commandHelper= new Command<>("!test",cmdDescript);
      addCommand(command2);
      addCommand(warnCommand);
      addCommand(voiceCommand);
      
    //   addCommand(commandHelper);

    // for(int i = 2 ;i<array.lenth; i++){
    //     String descr += array[i];
    // }
// String tmp = "!Command @user hahah ahah ahaha";

// System.out.println(tmp.substring(tmp.indexOf(" ",tmp.indexOf(" "))));


    
 }

    public void addCommand(Command command) {
        commands.put(command.getCommand(),command);
    }

    public Map<String,Command> getCommands() {
>>>>>>> 859468a60779971fb06626698f7065fc968b61b5
        return commands;
    }

    public static void main(String[] args) {
            Map<String,String> prop = new HashMap<>();



    }

}
