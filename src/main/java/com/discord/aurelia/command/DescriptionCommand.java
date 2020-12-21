package com.discord.aurelia.command;

import discord4j.core.event.domain.Event;

public class DescriptionCommand implements CommandInterface {

    @Override
    public void execute(Event event) {

    }

    @Override
    public String description() {
        return "DescrptionHelper";
    }
    
}
