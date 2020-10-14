package com.discord.aurelia.command;

import discord4j.core.event.domain.Event;

public class SubCommand<T extends Event> extends Command<T> {
    private Command<T> parent;
   private String command;
    private  CommandInterface<T> handler;
    public SubCommand(Command<T> parent,String command,CommandInterface<T> handler,String describtion){
        super(describtion);
        this.parent = parent;
        this.command=command;
        this.handler=handler;
    }

}
