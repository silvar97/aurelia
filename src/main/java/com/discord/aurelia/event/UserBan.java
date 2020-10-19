package com.discord.aurelia.event;

import java.util.Optional;

import org.springframework.core.GenericTypeResolver;
import org.springframework.stereotype.Component;

import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.Event;

import discord4j.core.event.domain.guild.BanEvent;
import discord4j.core.object.Ban;
import discord4j.core.object.entity.Member;
import discord4j.core.object.entity.User;



@Component
public class UserBan <T extends Event> implements EventListenerInterface<T> {

    

    @Override
    @SuppressWarnings("unchecked")
    public Class<T> getEventType() {

        return (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), UserManagementHandler.class);
    }
 
    @Override
    public void execute(T event) {
        hookOnEvent(event);

    }
    
    private final void hookOnEvent(Event event) {
       // if (event instanceof UserUpdateEvent){
       //    onUserUpdate((UserUpdateEvent) event); //Überprüft auf UserUpdateEvent
         
       // if (event instanceof BanEvent){
       //     getReason((BanEvent) event); //Checking BanEvent
       // }
   }

   //private void onUserUpdate(UserUpdateEvent event){
   // System.out.println(event.getCurrent().getAvatar()); //Reagiert auf Event
//}





}
