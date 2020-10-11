package com.discord.aurelia.command;




import discord4j.core.event.domain.Event;

public class Command<T extends Event>{
    
    private String command;
    private CommandInterface<T> handler;

    public Command(){
    }

    public Command(String command, CommandInterface<T> handler) {
        this.command = command;
        this.handler = handler;
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

}
