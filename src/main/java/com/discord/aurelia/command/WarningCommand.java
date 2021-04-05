package com.discord.aurelia.command;

import discord4j.core.event.domain.Event;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.rest.util.Color;
import discord4j.rest.util.Permission;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

import com.discord.aurelia.status.UserCommandAssociation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WarningCommand implements CommandInterface {

    @Autowired
    private UserCommandAssociation userCommandAssociation;
    
    @Override
    public void execute(Event event) {

        TempUserCommand tempUser= new TempUserCommand();

        tempUser.setMaxProp(2);
        tempUser.setTimeToLive(LocalDateTime.now().plusSeconds(60).toInstant(ZoneOffset.ofHours(1)).toEpochMilli());
        tempUser.addProp("warning", "3");
        tempUser.addProp("tempBan","100");
        tempUser.addProp("silvar","hübsch");
        tempUser.addProp("Rebas ","G@y");
        tempUser.addProp("NICO nico","FEMBOY");
        userCommandAssociation.addUserCommand(((MessageCreateEvent)event).getMember().get().getId().asLong(),tempUser);
    }   

    @Override
    public String description() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
