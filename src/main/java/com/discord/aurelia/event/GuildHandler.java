package com.discord.aurelia.event;

import org.springframework.core.GenericTypeResolver;
import org.springframework.stereotype.Component;

import discord4j.core.event.domain.Event;
import discord4j.core.event.domain.guild.GuildCreateEvent;
import discord4j.core.event.domain.guild.GuildDeleteEvent;
import discord4j.core.event.domain.guild.GuildUpdateEvent;
import discord4j.discordjson.json.gateway.GuildBanRemove;

@Component
public class GuildHandler<T extends Event> implements EventListenerInterface<T> {
    @Override
    @SuppressWarnings("unchecked")
    public Class<T> getEventType() {

        return (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), MessageHandler.class);
    }

    @Override
    public void execute(Event event) {
        hookOnEvent(event);
    }

    private void onGuildUpdate(GuildUpdateEvent event) {
    }

    private void onGuildDelete(GuildDeleteEvent event) {
    }

    private void onGuildCreate(GuildCreateEvent event) {
    }

    private void hookOnEvent(Event event) {
        if (event instanceof GuildCreateEvent)
            onGuildCreate((GuildCreateEvent) event);
        else if (event instanceof GuildDeleteEvent)
            onGuildDelete((GuildDeleteEvent) event);
        else if (event instanceof GuildUpdateEvent)
            onGuildUpdate((GuildUpdateEvent) event);
            
    }
    // addHandler(GuildBanRemove.class, GuildDispatchHandlers::guildBanRemove);
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
