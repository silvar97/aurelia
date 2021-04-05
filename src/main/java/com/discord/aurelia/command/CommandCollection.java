package com.discord.aurelia.command;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.discord.aurelia.handler.EmojiHandler;
import com.discord.aurelia.handler.VoiceChatHandler;
import com.discord.aurelia.handler.WarningHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import discord4j.core.event.domain.Event;
import discord4j.core.event.domain.guild.EmojisUpdateEvent;


@Component
@Order(1)
public class CommandCollection {

    private Map<String,Command> commands = new HashMap<>();
    @Autowired
    private EmojiHandler<EmojisUpdateEvent> emoji;
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
        return commands;
    }

    public static void main(String[] args) {
            Map<String,String> prop = new HashMap<>();



    }

}
