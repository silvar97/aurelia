package com.discord.aurelia.event;

import com.discord.aurelia.command.Command;
import com.discord.aurelia.command.CommandCollection;
import com.discord.aurelia.command.CommandInterface;
import com.discord.aurelia.temp.UserMessageMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import discord4j.common.util.Snowflake;
import discord4j.core.event.domain.Event;
import discord4j.core.event.domain.guild.BanEvent;
import discord4j.core.event.domain.guild.EmojisUpdateEvent;
import discord4j.core.event.domain.guild.UnbanEvent;
import discord4j.core.event.domain.message.MessageBulkDeleteEvent;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.event.domain.message.MessageDeleteEvent;
import discord4j.core.event.domain.message.MessageEvent;
import discord4j.core.event.domain.message.MessageUpdateEvent;
import discord4j.core.spec.BanQuerySpec;

@Component
@Order(1)
public class MessageHandler<T extends MessageEvent> implements CommandInterface {

    @Autowired
    private CommandCollection commandCollection;
    @Autowired
    private ApplicationContext context;
    @Autowired
    private UserMessageMap userMessageMap;
    @Autowired
    private CommandDescriptionHandler cmdHandler;
    public MessageHandler() {
        System.out.println("MessageHandler created");
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
        // if (event.getMessage().getContent().equals("!user")) {
        // event.getMessage().getChannel().block().createEmbed(e -> {
        // e.setAuthor(event.getMember().get().getUsername(),
        // event.getMember().get().getDefaultAvatarUrl(),
        // event.getMember().get().getAvatarUrl());
        // e.setColor(Color.RED);
        // e.addField("wer ist der größte noob?", "das weiß jeder",true);
        // e.setDescription("description");

        // }).block();

        // }
        // commands.getCommands().get("!ping").
        // event.getMessage().getChannel().block().createMessage("endlich").block();

        // commandCollection.getCommands().stream().filter(c ->
        // c.getCommand().equals(event.getMessage().getContent())).forEach(h->h.getHandler().execute(event));
        // context.getBean(commandCollection.getCommands().get("!ping").getHandlerclass()).execute(event);
        // context.getBean(commandCollection.getCommands().get("!guild").getHandlerclass()).execute(event);
        // commandCollection.getCommands().get("!emoji").getHandler().execute(event);

        // event.getMember().get().ban(member-> {
        // member.setReason("");
        // }).block();
        // event.getMember().get().unban();

        // if(reactionRoleCommand.getSize()>0){
        //     if(reactionRoleCommand.hasUser(event.getMember().get())==true){
        //         //das ist der richtige user der den command ausgeführt hat
        //         // optional den channel prüfen
        //         reactionRoleCommand.handle(event);
        //     }
        // }

        if(userMessageMap.containsMessageId(event.getMessage().getId().asLong())){
                cmdHandler.execute(event);
        }

       if (event.getMessage().getContent().matches("(^[^0-9A-Za-z])([a-z]+)(?: [a-zA-Z0-9\\D]+)?")) {
            Command command = commandCollection.getCommands().get(event.getMessage().getContent().split(" ")[0]);
            if (command != null) {
                command.getHandler().execute(event);
            }
        }

    }

    private void onMessageBulkDelete(MessageBulkDeleteEvent event) {

    }

    private void hookOnEvent(Event event) {
        if (event instanceof MessageBulkDeleteEvent)
            onMessageBulkDelete((MessageBulkDeleteEvent) event);
        else if (event instanceof MessageCreateEvent)
            onMessageCreate((MessageCreateEvent) event);
        else if (event instanceof MessageDeleteEvent)
            onMessageDelete((MessageDeleteEvent) event);
        else if (event instanceof MessageUpdateEvent)
            onMessageUpdate((MessageUpdateEvent) event);
    }

    @Override
    public String toString() {
        return "messageHandler";
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return null;
    }

}
