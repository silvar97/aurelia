package com.discord.aurelia.configuration;


<<<<<<< HEAD
import javax.annotation.PostConstruct;

import com.discord.aurelia.AureliaApplication;
import com.discord.aurelia.dao.ChannelDao;
import com.discord.aurelia.event.CustomEventDispatcher;
import com.discord.aurelia.event.MessageHandler;
import com.discord.aurelia.event.UserManagementHandler;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.CaffeineSpec;

import org.springframework.beans.factory.annotation.Autowired;
=======
>>>>>>> 9d5468d57d3be4f98decee5deb5486f7268c85e1
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;

@Configuration
@Order(4)
public class AureliaBotConfig {

    @Value("${token}")
    private String token;

    public AureliaBotConfig() {
        System.out.println("AureliaBotConfig created");
    }

    @Bean
    public GatewayDiscordClient gateway() {
        final DiscordClient client = DiscordClient.create(token);
        final GatewayDiscordClient gateway = client.login().block();
        
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