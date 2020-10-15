package com.discord.aurelia.command;

import discord4j.core.event.domain.Event;

public class Command<T extends CommandInterface>{

    private String describtion;
    private String command;
    private Class<? extends CommandInterface> handlerclass;
    public Command(){
    }
  
    public Command(String command,Class<? extends CommandInterface> handlerclass) {
        this.command = command;
        this.handlerclass= handlerclass;
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

}
