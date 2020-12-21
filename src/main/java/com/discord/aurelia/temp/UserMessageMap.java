package com.discord.aurelia.temp;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.persistence.sessions.coordination.CommandManager;
import org.springframework.stereotype.Component;

@Component
public class UserMessageMap {

    private final List<Long> commandHelperMessages;

    public UserMessageMap(){
        commandHelperMessages = new ArrayList<>();
        System.out.println("userMessageMap created!");
    }
    
    public boolean containsMessageId(Long messageId){
        return  commandHelperMessages.contains(messageId);
    }
    public void add(Long id){
        commandHelperMessages.add(id);
    }

}
