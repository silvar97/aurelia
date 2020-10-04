package com.discord.aurelia.event;



import org.springframework.core.GenericTypeResolver;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import discord4j.core.event.domain.Event;
import discord4j.core.event.domain.message.MessageBulkDeleteEvent;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.event.domain.message.MessageDeleteEvent;
import discord4j.core.event.domain.message.MessageUpdateEvent;

@Component
public class MessageHandler<T extends Event> implements EventListenerInterface<T>{
    @Override
    @SuppressWarnings("unchecked")
    public Class<T> getEventType() {

        return (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), MessageHandler.class);
    }

    @Override
    public void execute(Event event) {
            hookOnEvent(event);
    }
    

    private void onMessageUpdate(MessageUpdateEvent event) {
        
    }

    private void onMessageDelete(MessageDeleteEvent event) {
        
        event.getChannel().block().createMessage("message deletion").block();

        
    }

    
    private void onMessageCreate(MessageCreateEvent event) {
        if(event.getMessage().getContent().equals("!ping")){

            event.getMessage().getChannel().block().createMessage("wer ist der größte noob").block();
        }
     
 }

    private void onMessageBulkDelete(MessageBulkDeleteEvent event) {
       
    }
    private void hookOnEvent(Event event) {
        if (event instanceof MessageBulkDeleteEvent) onMessageBulkDelete((MessageBulkDeleteEvent) event);
       else if (event instanceof MessageCreateEvent) onMessageCreate((MessageCreateEvent) event);
       else if (event instanceof MessageDeleteEvent) onMessageDelete((MessageDeleteEvent) event);
       else if (event instanceof MessageUpdateEvent) onMessageUpdate((MessageUpdateEvent) event);
   }
}
