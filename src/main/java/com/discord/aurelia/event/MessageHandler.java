package com.discord.aurelia.event;

import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.core.GenericTypeResolver;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import discord4j.core.event.domain.Event;
import discord4j.core.event.domain.message.MessageBulkDeleteEvent;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.event.domain.message.MessageDeleteEvent;
import discord4j.core.event.domain.message.MessageUpdateEvent;
import discord4j.core.object.Embed;
import discord4j.core.spec.EmbedCreateSpec;
import discord4j.discordjson.json.EmbedAuthorData;
import discord4j.discordjson.json.EmbedData;
import discord4j.discordjson.json.EmbedThumbnailData;
import discord4j.discordjson.json.ImmutableEmbedData;
import discord4j.discordjson.json.MessageData;
import discord4j.rest.util.Color;

@Component
public class MessageHandler<T extends Event> implements EventListenerInterface<T> {
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
        if (event.getMessage().getContent().equals("!a")) {
         
    

            event.getMessage().getChannel().block().createEmbed(e -> {
                e.setAuthor(event.getMember().get().getUsername(), event.getMember().get().getDefaultAvatarUrl(), event.getMember().get().getAvatarUrl());
         e.setColor(Color.BLUE);
         e.addField("Test 1", "Habib 1",true);
         e.addField("Test 2", "Habib 2", true);
         e.setDescription("Habib gib ruhe!");
    
            }).block();

          }
        if (event.getMessage().getContent().equals("!test")){

            
            
            
            
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
