package com.discord.aurelia.command;

import discord4j.core.event.domain.Event;

public class Command<T extends CommandInterface>{

    private String describtion;
    private String command;
    private Class<? extends CommandInterface> handlerclass;
    private CommandInterface handler;
    public Command(){
    }
  
    public Command(String command,Class<? extends CommandInterface> handlerclass) {
        this.command = command;
        this.handlerclass= handlerclass;
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

    public Class<? extends CommandInterface> getHandlerclass() {
        return handlerclass;
    }

    public void setHandlerclass(Class<? extends CommandInterface> handlerclass) {
        this.handlerclass = handlerclass;
    }

    public CommandInterface getHandler() {
        return handler;
    }

    public void setHandler(CommandInterface handler) {
        this.handler = handler;
    }

}
