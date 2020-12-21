package com.discord.aurelia.event;

import java.nio.channels.CompletionHandler;

import com.discord.aurelia.command.CommandCollection;
import com.github.benmanes.caffeine.cache.Cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.core.GenericTypeResolver;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import discord4j.core.event.domain.Event;
import discord4j.core.event.domain.PresenceUpdateEvent;
import discord4j.core.event.domain.UserUpdateEvent;
import discord4j.core.event.domain.VoiceServerUpdateEvent;
import discord4j.core.event.domain.VoiceStateUpdateEvent;
import discord4j.core.event.domain.WebhooksUpdateEvent;
import discord4j.core.event.domain.channel.CategoryCreateEvent;
import discord4j.core.event.domain.channel.CategoryDeleteEvent;
import discord4j.core.event.domain.channel.CategoryUpdateEvent;
import discord4j.core.event.domain.channel.NewsChannelCreateEvent;
import discord4j.core.event.domain.channel.NewsChannelDeleteEvent;
import discord4j.core.event.domain.channel.NewsChannelUpdateEvent;
import discord4j.core.event.domain.channel.PinsUpdateEvent;
import discord4j.core.event.domain.channel.PrivateChannelCreateEvent;
import discord4j.core.event.domain.channel.PrivateChannelDeleteEvent;
import discord4j.core.event.domain.channel.StoreChannelCreateEvent;
import discord4j.core.event.domain.channel.StoreChannelDeleteEvent;
import discord4j.core.event.domain.channel.StoreChannelUpdateEvent;
import discord4j.core.event.domain.channel.TextChannelCreateEvent;
import discord4j.core.event.domain.channel.TextChannelDeleteEvent;
import discord4j.core.event.domain.channel.TextChannelUpdateEvent;
import discord4j.core.event.domain.channel.TypingStartEvent;
import discord4j.core.event.domain.channel.VoiceChannelCreateEvent;
import discord4j.core.event.domain.channel.VoiceChannelDeleteEvent;
import discord4j.core.event.domain.channel.VoiceChannelUpdateEvent;
import discord4j.core.event.domain.guild.BanEvent;
import discord4j.core.event.domain.guild.EmojisUpdateEvent;
import discord4j.core.event.domain.guild.GuildCreateEvent;
import discord4j.core.event.domain.guild.GuildDeleteEvent;
import discord4j.core.event.domain.guild.GuildEvent;
import discord4j.core.event.domain.guild.GuildUpdateEvent;
import discord4j.core.event.domain.guild.IntegrationsUpdateEvent;
import discord4j.core.event.domain.guild.MemberChunkEvent;
import discord4j.core.event.domain.guild.MemberJoinEvent;
import discord4j.core.event.domain.guild.MemberLeaveEvent;
import discord4j.core.event.domain.guild.MemberUpdateEvent;
import discord4j.core.event.domain.guild.UnbanEvent;
import discord4j.core.event.domain.lifecycle.ConnectEvent;
import discord4j.core.event.domain.lifecycle.DisconnectEvent;
import discord4j.core.event.domain.lifecycle.ReadyEvent;
import discord4j.core.event.domain.lifecycle.ReconnectEvent;
import discord4j.core.event.domain.lifecycle.ReconnectFailEvent;
import discord4j.core.event.domain.lifecycle.ReconnectStartEvent;
import discord4j.core.event.domain.lifecycle.ResumeEvent;
import discord4j.core.event.domain.message.MessageBulkDeleteEvent;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.event.domain.message.MessageDeleteEvent;
import discord4j.core.event.domain.message.MessageEvent;
import discord4j.core.event.domain.message.MessageUpdateEvent;
import discord4j.core.event.domain.message.ReactionAddEvent;
import discord4j.core.event.domain.message.ReactionRemoveAllEvent;
import discord4j.core.event.domain.message.ReactionRemoveEvent;
import discord4j.core.event.domain.role.RoleCreateEvent;
import discord4j.core.event.domain.role.RoleDeleteEvent;
import discord4j.core.event.domain.role.RoleUpdateEvent;
import discord4j.core.object.entity.channel.Channel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service(value = "customEventDispatcher")
@Order(2)
public class CustomEventDispatcher<T extends Event> implements EventListenerInterface<T> {

    @Autowired
    private MessageHandler<MessageEvent> messageHandler;
    @Autowired
    private EmojiHandler<EmojisUpdateEvent> emojiHandler;
    @Autowired
    private GuildHandler<GuildEvent> guildHandler;
    @Autowired
    @Qualifier("commandCollection")
    private CommandCollection commands;
    @Autowired
    private CacheManager cacheManager;
    // @Autowired
    // private CommandDescriptionHandler cmdDescHandler;
    // @Autowired
    // private GatewayDiscordClient gateway;
    @Override
    @SuppressWarnings("unchecked")
    public Class<T> getEventType() {

        return (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), CustomEventDispatcher.class);
    }

    public CustomEventDispatcher() {

        System.out.println("customer listener init");
    }

    @Override
    public void execute(final T event) {
        hookOnEvent(event);
    }

    public Mono<Void> onPresenceUpdate(PresenceUpdateEvent event) {
        return Mono.empty();
    }

    public Mono<Void> onUserUpdate(UserUpdateEvent event) {
        return Mono.empty();
    }

    public Mono<Void> onVoiceServerUpdate(VoiceServerUpdateEvent event) {
        return Mono.empty();
    }

    public Mono<Void> onVoiceStateUpdate(VoiceStateUpdateEvent event) {
        return Mono.empty();
    }

    public Mono<Void> onWebhooksUpdate(WebhooksUpdateEvent event) {
        return Mono.empty();
    }

    public Mono<Void> onCategoryCreate(CategoryCreateEvent event) {
        return Mono.empty();
    }

    public Mono<Void> onCategoryDelete(CategoryDeleteEvent event) {
        return Mono.empty();
    }

    public Mono<Void> onCategoryUpdate(CategoryUpdateEvent event) {
        return Mono.empty();
    }

    public Mono<Void> onNewsChannelCreate(NewsChannelCreateEvent event) {
        return Mono.empty();
    }

    public Mono<Void> onNewsChannelDelete(NewsChannelDeleteEvent event) {
        return Mono.empty();
    }

    public Mono<Void> onNewsChannelUpdate(NewsChannelUpdateEvent event) {
        return Mono.empty();
    }

    public Mono<Void> onPinsUpdate(PinsUpdateEvent event) {
        return Mono.empty();
    }

    public Mono<Void> onPrivateChannelCreate(PrivateChannelCreateEvent event) {
        return Mono.empty();
    }

    public Mono<Void> onPrivateChannelDelete(PrivateChannelDeleteEvent event) {
        return Mono.empty();
    }

    public Mono<Void> onStoreChannelCreate(StoreChannelCreateEvent event) {
        return Mono.empty();
    }

    public Mono<Void> onStoreChannelDelete(StoreChannelDeleteEvent event) {
        return Mono.empty();
    }

    public Mono<Void> onStoreChannelUpdate(StoreChannelUpdateEvent event) {
        return Mono.empty();
    }

    public Mono<Void> onTextChannelCreate(TextChannelCreateEvent event) {
        return Mono.empty();
    }

    public Mono<Void> onTextChannelDelete(TextChannelDeleteEvent event) {
        return Mono.empty();
    }

    public Mono<Void> onTextChannelUpdate(TextChannelUpdateEvent event) {

        return Mono.empty();
    }

    public Mono<Void> onTypingStart(TypingStartEvent event) {
        return Mono.empty();
    }

    public Mono<Void> onVoiceChannelCreate(VoiceChannelCreateEvent event) {
        
        return Mono.empty();
    }

    public Mono<Void> onVoiceChannelDelete(VoiceChannelDeleteEvent event) {
        return Mono.empty();
    }

    public Mono<Void> onVoiceChannelUpdate(VoiceChannelUpdateEvent event) {
        return Mono.empty();
    }

    public Mono<Void> onBan(BanEvent event) {
        return Mono.empty();
    }

    public Mono<Void> onEmojisUpdate(EmojisUpdateEvent event) {
        emojiHandler.handle(event);
        return Mono.empty();
    }

    public Mono<Void> onGuildCreate(GuildCreateEvent event) {
        guildHandler.handle(event);
        return Mono.empty();
    }

    public Mono<Void> onGuildDelete(GuildDeleteEvent event) {
        guildHandler.handle(event);
        return Mono.empty();
    }

    public Mono<Void> onGuildUpdate(GuildUpdateEvent event) {
        guildHandler.handle(event);
        return Mono.empty();
    }

    public Mono<Void> onIntegrationsUpdate(IntegrationsUpdateEvent event) {
        return Mono.empty();
    }

    public Mono<Void> onMemberChunk(MemberChunkEvent event) {

        return Mono.empty();
    }

    public Mono<Void> onMemberJoin(MemberJoinEvent event) {
        return Mono.empty();
    }

    public Mono<Void> onMemberLeave(MemberLeaveEvent event) {
        return Mono.empty();
    }

    public Mono<Void> onMemberUpdate(MemberUpdateEvent event) {
        return Mono.empty();
    }

    public Mono<Void> onUnban(UnbanEvent event) {
        return Mono.empty();
    }

    public Mono<Void> onConnect(ConnectEvent event) {
        return Mono.empty();
    }

    public Mono<Void> onDisconnect(DisconnectEvent event) {
        return Mono.empty();
    }

    public Mono<Void> onReady(ReadyEvent event) {
        return Mono.empty();
    }

    public Mono<Void> onReconnect(ReconnectEvent event) {
        return Mono.empty();
    }

    public Mono<Void> onReconnectFail(ReconnectFailEvent event) {
        return Mono.empty();
    }

    public Mono<Void> onReconnectStart(ReconnectStartEvent event) {
        return Mono.empty();
    }

    public Mono<Void> onResume(ResumeEvent event) {
        return Mono.empty();
    }

    public Mono<Void> onMessageBulkDelete(MessageBulkDeleteEvent event) {

        return Mono.empty();
    }

    public Mono<Void> onMessageCreate(MessageCreateEvent event) {

        /*
         * channelSerive.getChannel(event.getMessage().getChannel().block().getId());
         * Cache nativeCoffeeCache = (Cache)
         * cacheManager.getCache("channel").getNativeCache();
         * System.out.println(nativeCoffeeCache.stats());
         */

        messageHandler.execute(event);
        return Mono.empty();
    }

    public Mono<Void> onMessageDelete(MessageDeleteEvent event) {

        return Mono.empty();
    }

    public Mono<Void> onMessageUpdate(MessageUpdateEvent event) {

        return Mono.empty();
    }

    public Mono<Void> onReactionAdd(ReactionAddEvent event) {
        // cmdDescHandler.execute(event);
        return Mono.empty();
    }

    public Mono<Void> onReactionRemoveAll(ReactionRemoveAllEvent event) {
        
        return Mono.empty();
    }

    public Mono<Void> onReactionRemove(ReactionRemoveEvent event) {
        // cmdDescHandler.execute(event);
        return Mono.empty();
    }

    public Mono<Void> onRoleCreate(RoleCreateEvent event) {
        return Mono.empty();
    }

    public Mono<Void> onRoleDelete(RoleDeleteEvent event) {
        return Mono.empty();
    }

    public Mono<Void> onRoleUpdate(RoleUpdateEvent event) {
        return Mono.empty();
    }

    public Flux<Event> listener(Flux<Event> events) {
        return events.flatMap(event -> hookOnEvent(event).onErrorResume(t -> {
            // log.error("Error while handling event", t);
            System.out.println("error");
            return Mono.empty();
        }).thenReturn(event));
    }

    public final Mono<Void> hookOnEvent(Event event) {
        if (event instanceof PresenceUpdateEvent)
            return onPresenceUpdate((PresenceUpdateEvent) event);
        else if (event instanceof UserUpdateEvent)
            return onUserUpdate((UserUpdateEvent) event);
        else if (event instanceof VoiceServerUpdateEvent)
            return onVoiceServerUpdate((VoiceServerUpdateEvent) event);
        else if (event instanceof VoiceStateUpdateEvent)
            return onVoiceStateUpdate((VoiceStateUpdateEvent) event);
        else if (event instanceof WebhooksUpdateEvent)
            return onWebhooksUpdate((WebhooksUpdateEvent) event);
        else if (event instanceof CategoryCreateEvent)
            return onCategoryCreate((CategoryCreateEvent) event);
        else if (event instanceof CategoryDeleteEvent)
            return onCategoryDelete((CategoryDeleteEvent) event);
        else if (event instanceof CategoryUpdateEvent)
            return onCategoryUpdate((CategoryUpdateEvent) event);
        else if (event instanceof NewsChannelCreateEvent)
            return onNewsChannelCreate((NewsChannelCreateEvent) event);
        else if (event instanceof NewsChannelDeleteEvent)
            return onNewsChannelDelete((NewsChannelDeleteEvent) event);
        else if (event instanceof NewsChannelUpdateEvent)
            return onNewsChannelUpdate((NewsChannelUpdateEvent) event);
        else if (event instanceof PinsUpdateEvent)
            return onPinsUpdate((PinsUpdateEvent) event);
        else if (event instanceof PrivateChannelCreateEvent)
            return onPrivateChannelCreate((PrivateChannelCreateEvent) event);
        else if (event instanceof PrivateChannelDeleteEvent)
            return onPrivateChannelDelete((PrivateChannelDeleteEvent) event);
        else if (event instanceof StoreChannelCreateEvent)
            return onStoreChannelCreate((StoreChannelCreateEvent) event);
        else if (event instanceof StoreChannelDeleteEvent)
            return onStoreChannelDelete((StoreChannelDeleteEvent) event);
        else if (event instanceof StoreChannelUpdateEvent)
            return onStoreChannelUpdate((StoreChannelUpdateEvent) event);
        else if (event instanceof TextChannelCreateEvent)
            return onTextChannelCreate((TextChannelCreateEvent) event);
        else if (event instanceof TextChannelDeleteEvent)
            return onTextChannelDelete((TextChannelDeleteEvent) event);
        else if (event instanceof TextChannelUpdateEvent)
            return onTextChannelUpdate((TextChannelUpdateEvent) event);
        else if (event instanceof TypingStartEvent)
            return onTypingStart((TypingStartEvent) event);
        else if (event instanceof VoiceChannelCreateEvent)
            return onVoiceChannelCreate((VoiceChannelCreateEvent) event);
        else if (event instanceof VoiceChannelDeleteEvent)
            return onVoiceChannelDelete((VoiceChannelDeleteEvent) event);
        else if (event instanceof VoiceChannelUpdateEvent)
            return onVoiceChannelUpdate((VoiceChannelUpdateEvent) event);
        else if (event instanceof BanEvent)
            return onBan((BanEvent) event);
        else if (event instanceof EmojisUpdateEvent)
            return onEmojisUpdate((EmojisUpdateEvent) event);
        else if (event instanceof GuildCreateEvent)
            return onGuildCreate((GuildCreateEvent) event);
        else if (event instanceof GuildDeleteEvent)
            return onGuildDelete((GuildDeleteEvent) event);
        else if (event instanceof GuildUpdateEvent)
            return onGuildUpdate((GuildUpdateEvent) event);
        else if (event instanceof IntegrationsUpdateEvent)
            return onIntegrationsUpdate((IntegrationsUpdateEvent) event);
        else if (event instanceof MemberChunkEvent)
            return onMemberChunk((MemberChunkEvent) event);
        else if (event instanceof MemberJoinEvent)
            return onMemberJoin((MemberJoinEvent) event);
        else if (event instanceof MemberLeaveEvent)
            return onMemberLeave((MemberLeaveEvent) event);
        else if (event instanceof MemberUpdateEvent)
            return onMemberUpdate((MemberUpdateEvent) event);
        else if (event instanceof UnbanEvent)
            return onUnban((UnbanEvent) event);
        else if (event instanceof ConnectEvent)
            return onConnect((ConnectEvent) event);
        else if (event instanceof DisconnectEvent)
            return onDisconnect((DisconnectEvent) event);
        else if (event instanceof ReadyEvent)
            return onReady((ReadyEvent) event);
        else if (event instanceof ReconnectEvent)
            return onReconnect((ReconnectEvent) event);
        else if (event instanceof ReconnectFailEvent)
            return onReconnectFail((ReconnectFailEvent) event);
        else if (event instanceof ReconnectStartEvent)
            return onReconnectStart((ReconnectStartEvent) event);
        else if (event instanceof ResumeEvent)
            return onResume((ResumeEvent) event);
        else if (event instanceof MessageBulkDeleteEvent)
            return onMessageBulkDelete((MessageBulkDeleteEvent) event);
        else if (event instanceof MessageCreateEvent)
            return onMessageCreate((MessageCreateEvent) event);
        else if (event instanceof MessageDeleteEvent)
            return onMessageDelete((MessageDeleteEvent) event);
        else if (event instanceof MessageUpdateEvent)
            return onMessageUpdate((MessageUpdateEvent) event);
        else if (event instanceof ReactionAddEvent)
            return onReactionAdd((ReactionAddEvent) event);
        else if (event instanceof ReactionRemoveAllEvent)
            return onReactionRemoveAll((ReactionRemoveAllEvent) event);
        else if (event instanceof ReactionRemoveEvent)
            return onReactionRemove((ReactionRemoveEvent) event);
        else if (event instanceof RoleCreateEvent)
            return onRoleCreate((RoleCreateEvent) event);
        else if (event instanceof RoleDeleteEvent)
            return onRoleDelete((RoleDeleteEvent) event);
        else if (event instanceof RoleUpdateEvent)
            return onRoleUpdate((RoleUpdateEvent) event);

        return Mono.empty();
    }

}