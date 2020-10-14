package com.discord.aurelia.command;

import discord4j.core.event.domain.Event;

public class Command<T extends Event>{

    private String describtion;
    private String command;
    private CommandInterface<T> handler;

    public Command(){
    }
    public Command(String describtion){
        this.describtion = describtion;
    }
    public Command(String command, CommandInterface<T> handler) {
        this.command = command;
        this.handler = handler;
    }
    public Command(String command, CommandInterface<T> handler,String describtion) {
        this.command = command;
        this.handler = handler;
        this.describtion= describtion;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public CommandInterface<T> getHandler() {
        return handler;
    }

    public void setHandler(CommandInterface<T> handler) {
        this.handler = handler;
    }

    public String getDescribtion() {
        return describtion;
    }

    public void setDescribtion(String describtion) {
        this.describtion = describtion;
    }

}
