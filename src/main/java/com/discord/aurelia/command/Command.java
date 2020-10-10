package com.discord.aurelia.command;




import discord4j.core.event.domain.Event;

public class Command<T extends Event>{
    
    private String command;
    private CommandInterface<T> event;

    public Command(){
    }

    public Command(String command, CommandInterface<T> event) {
        this.command = command;
        this.event = event;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public CommandInterface<T> getEvent() {
        return event;
    }

    public void setEvent(CommandInterface<T> event) {
        this.event = event;
    }

}
