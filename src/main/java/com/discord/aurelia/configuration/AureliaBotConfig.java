package com.discord.aurelia.configuration;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import com.discord.aurelia.AureliaApplication;
import com.discord.aurelia.dao.ChannelDao;
import com.discord.aurelia.event.CustomEventDispatcher;
import com.discord.aurelia.event.MessageHandler;
import com.discord.aurelia.event.UserManagementHandler;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.CaffeineSpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import discord4j.common.util.Snowflake;
import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.Event;
<<<<<<< HEAD
import discord4j.core.event.domain.message.MessageEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.GuildChannel;
import discord4j.core.object.entity.channel.MessageChannel;
import discord4j.core.object.entity.channel.TextChannel;
import discord4j.core.object.presence.Activity;
import discord4j.core.object.presence.Presence;
import discord4j.discordjson.json.gateway.ImmutableChannelCreate;
import discord4j.rest.entity.RestChannel;
import reactor.core.publisher.Mono;
=======
>>>>>>> 48e58cf43c0d34353a07e73eaf457d74c3aa4c8a

@Configuration
@DependsOn("cacheManagerConfig")
public class AureliaBotConfig{

    @Value("${token}")
    private String token;
    @Autowired
    private  CustomEventDispatcher<Event> customEventDispatcher;

    //@Autowired
   // private EmojiHandler<EmojisUpdateEvent> emojiHandler;
public AureliaBotConfig(){
    System.out.println("AureliaBotConfig created");
}
    @Bean
    public GatewayDiscordClient gateway(){
        final DiscordClient client = DiscordClient.create(token);
        final GatewayDiscordClient gateway = client.login().block();
        gateway.getEventDispatcher().on(customEventDispatcher.getEventType()).subscribe(customEventDispatcher::execute);
    //     // gateway.getGuilds().collectList().block().forEach(g->{
    //     //     g.getChannels().collectList().block().forEach(c->{
    //     //    c.getRestChannel().create     
    //     //     });
    //     // });
    // //    Mono<Message> msg= gateway.getMessageById(Snowflake.of(759138832896884777l), Snowflake.of(759511710087774269l));
        
    // //    msg.block().getChannel().block().createMessage("Hallo").block();
    // // MessageCreateRequest    msgCreate = new MessageCreateRe
    //   gateway.getChannelById(Snowflake.of(759138832896884779l)).block().getRestChannel().createMessage("ach lass mich einfach bin weg").block();
    return gateway;
    }

}
// addHandler(ChannelCreate.class, ChannelDispatchHandlers::channelCreate);
// addHandler(ChannelDelete.class, ChannelDispatchHandlers::channelDelete);
// addHandler(ChannelPinsUpdate.class, ChannelDispatchHandlers::channelPinsUpdate);
// addHandler(ChannelUpdate.class, ChannelDispatchHandlers::channelUpdate);
// addHandler(GuildBanAdd.class, GuildDispatchHandlers::guildBanAdd);
// addHandler(GuildBanRemove.class, GuildDispatchHandlers::guildBanRemove);
// addHandler(GuildCreate.class, GuildDispatchHandlers::guildCreate);
// addHandler(GuildDelete.class, GuildDispatchHandlers::guildDelete);
// addHandler(GuildEmojisUpdate.class, GuildDispatchHandlers::guildEmojisUpdate);
// addHandler(GuildIntegrationsUpdate.class, GuildDispatchHandlers::guildIntegrationsUpdate);
// addHandler(GuildMemberAdd.class, GuildDispatchHandlers::guildMemberAdd);
// addHandler(GuildMemberRemove.class, GuildDispatchHandlers::guildMemberRemove);
// addHandler(GuildMembersChunk.class, GuildDispatchHandlers::guildMembersChunk);
// addHandler(GuildMemberUpdate.class, GuildDispatchHandlers::guildMemberUpdate);
// addHandler(GuildRoleCreate.class, GuildDispatchHandlers::guildRoleCreate);
// addHandler(GuildRoleDelete.class, GuildDispatchHandlers::guildRoleDelete);
// addHandler(GuildRoleUpdate.class, GuildDispatchHandlers::guildRoleUpdate);
// addHandler(GuildUpdate.class, GuildDispatchHandlers::guildUpdate);
// addHandler(MessageCreate.class, MessageDispatchHandlers::messageCreate);
// addHandler(MessageDelete.class, MessageDispatchHandlers::messageDelete);
// addHandler(MessageDeleteBulk.class, MessageDispatchHandlers::messageDeleteBulk);
// addHandler(MessageReactionAdd.class, MessageDispatchHandlers::messageReactionAdd);
// addHandler(MessageReactionRemove.class, MessageDispatchHandlers::messageReactionRemove);
// addHandler(MessageReactionRemoveEmoji.class, MessageDispatchHandlers::messageReactionRemoveEmoji);
// addHandler(MessageReactionRemoveAll.class, MessageDispatchHandlers::messageReactionRemoveAll);
// addHandler(MessageUpdate.class, MessageDispatchHandlers::messageUpdate);
// addHandler(PresenceUpdate.class, DispatchHandlers::presenceUpdate);
// addHandler(Ready.class, LifecycleDispatchHandlers::ready);
// addHandler(Resumed.class, LifecycleDispatchHandlers::resumed);
// addHandler(TypingStart.class, DispatchHandlers::typingStart);
// addHandler(UserUpdate.class, DispatchHandlers::userUpdate);
// addHandler(VoiceServerUpdate.class, DispatchHandlers::voiceServerUpdate);
// addHandler(VoiceStateUpdateDispatch.class, DispatchHandlers::voiceStateUpdateDispatch);
// addHandler(WebhooksUpdate.class, DispatchHandlers::webhooksUpdate);
// addHandler(InviteCreate.class, DispatchHandlers::inviteCreate);
// addHandler(InviteDelete.class, DispatchHandlers::inviteDelete);