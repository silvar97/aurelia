package com.discord.aurelia.command;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class Command{

    private String describtion;
    private String command;
    private CommandInterface handler;
    public Command(){
    }
  
    public Command(String command,Class<? extends CommandInterface> handlerclass) {
        this.command = command;

    }
    public Command(String command,CommandInterface handler) {
        this.command = command;
        this.handler= handler;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
    public String getDescribtion() {
        return describtion;
    }

    public void setDescribtion(String describtion) {
        this.describtion = describtion;
    }

    public CommandInterface getHandler() {
        return handler;
    }

    public void setHandler(CommandInterface handler) {
        this.handler = handler;
    }

}
