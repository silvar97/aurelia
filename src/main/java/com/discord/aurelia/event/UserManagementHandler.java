package com.discord.aurelia.event;

import org.springframework.core.GenericTypeResolver;
import org.springframework.stereotype.Component;

import discord4j.core.event.domain.Event;
import discord4j.core.event.domain.UserUpdateEvent;



@Component
public class UserManagementHandler <T extends Event> implements EventListenerInterface<T> {

    @Override
    @SuppressWarnings("unchecked")
    public Class<T> getEventType() {

        return (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), UserManagementHandler.class);
    }

    @Override
    public void execute(T event) {
        hookOnEvent(event);

    }

    private final void  hookOnEvent(Event event) {
        if (event instanceof UserUpdateEvent){
            onUserUpdate((UserUpdateEvent) event); //Überprüft auf UserUpdateEvent
        } 
   }

   private void onUserUpdate(UserUpdateEvent event){
    System.out.println(event.getCurrent().getAvatar()); //Reagiert auf Event
}

}
