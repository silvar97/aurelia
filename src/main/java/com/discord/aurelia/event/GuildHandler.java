package com.discord.aurelia.event;

import com.discord.aurelia.command.CommandInterface;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import discord4j.core.event.domain.Event;
import discord4j.core.event.domain.guild.GuildCreateEvent;
import discord4j.core.event.domain.guild.GuildDeleteEvent;
import discord4j.core.event.domain.guild.GuildEvent;
import discord4j.core.event.domain.guild.GuildUpdateEvent;

@Component
@Order(1)
public class GuildHandler<T extends GuildEvent> implements CommandInterface {

    public void handle(GuildUpdateEvent event) {

    }

    public void handle(GuildDeleteEvent event) {

    }

    public void handle(GuildCreateEvent event) {

    }
    // private void onGuildUpdate(GuildUpdateEvent event) {
    // }

    @Override
    public void execute(Event event) {
        System.out.println("guildHandler");
    }

    @Override
    public String description() {
        // TODO Auto-generated method stub
        return "null";
    }

  

    // private void onGuildDelete(GuildDeleteEvent event) {
    // }

    // private void onGuildCreate(GuildCreateEvent event) {
    // }

    // private void hookOnEvent(Event event) {
    //     if (event instanceof GuildCreateEvent)
    //         onGuildCreate((GuildCreateEvent) event);
    //     else if (event instanceof GuildDeleteEvent)
    //         onGuildDelete((GuildDeleteEvent) event);
    //     else if (event instanceof GuildUpdateEvent)
    //         onGuildUpdate((GuildUpdateEvent) event);
            
    // }
    // // addHandler(GuildBanRemove.class, GuildDispatchHandlers::guildBanRemove);
    // GuildDispatchHandlers::guildEmojisUpdate);
    // addHandler(GuildIntegrationsUpdate.class,
    // GuildDispatchHandlers::guildIntegrationsUpdate);
    // addHandler(GuildMemberAdd.class, GuildDispatchHandlers::guildMemberAdd);
    // addHandler(GuildMemberRemove.class,
    // GuildDispatchHandlers::guildMemberRemove);
    // addHandler(GuildMembersChunk.class,
    // GuildDispatchHandlers::guildMembersChunk);
    // addHandler(GuildMemberUpdate.class,
    // GuildDispatchHandlers::guildMemberUpdate);
    // addHandler(GuildRoleCreate.class, GuildDispatchHandlers::guildRoleCreate);
    // addHandler(GuildRoleDelete.class, GuildDispatchHandlers::guildRoleDelete);
    // addHandler(GuildRoleUpdate.class, GuildDispatchHandlers::guildRoleUpdate);
    // addHandler(GuildUpdate.class, GuildDispatchHandlers::guildUpdate);

}
