package com.discord.aurelia.timer;

import com.discord.aurelia.status.UserCommandAssociation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class UserCommandRemover {
    @Autowired
    private UserCommandAssociation userCommandMap;

    public UserCommandRemover(){
    System.out.println("UserCOmmandRemover");
    }


    @Scheduled(fixedDelay = 20000)
    public void removeUserCommands(){
        userCommandMap.getUserCommandTime().entrySet().removeIf(c->c.getValue().getTimeToLive()>=System.currentTimeMillis());
    }

}
