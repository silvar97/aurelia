package com.discord.aurelia.status;

import java.util.HashMap;
import java.util.Map;

import com.discord.aurelia.command.TempUserCommand;

import org.springframework.stereotype.Component;

@Component
public class UserCommandAssociation {

    private final Map<Long,TempUserCommand> userCommandTime;
    
    public UserCommandAssociation(){
        userCommandTime = new HashMap<>();
        System.out.println("userMessageMap created!");
    }
    
    public boolean hasCommandLeft(Long userId){
        return  userCommandTime.containsKey(userId);
    }
    public int getSize(){
        return userCommandTime.size();
    }

    public void addUserCommand(Long userId,TempUserCommand tempUserCommand){

        userCommandTime.put(userId,tempUserCommand);
    }

    public Map<Long, TempUserCommand> getUserCommandTime() {
        return userCommandTime;
    }


}
