package com.discord.aurelia.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import discord4j.common.util.Snowflake;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.object.entity.Guild;
import discord4j.core.object.entity.GuildEmoji;
import discord4j.core.object.entity.Member;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.Role;
import discord4j.core.object.entity.User;
import discord4j.core.object.entity.channel.Channel;
import discord4j.core.object.entity.channel.GuildChannel;
import discord4j.core.retriever.EntityRetriever;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Order(2)
@CacheConfig(cacheNames = {"gateway"})
public class GatewayService implements EntityRetriever {
    private static final Logger LOG = LoggerFactory.getLogger(GatewayService.class);
    @Autowired
    private GatewayDiscordClient gateway;

    @Override
    @Cacheable(cacheNames = "mono")
    public Mono<Channel> getChannelById(Snowflake channelId) {
       LOG.info("gatewayService getChannelById no hit!");
        return gateway.getChannelById(channelId);
    }

    @Override
    public Mono<Guild> getGuildById(Snowflake guildId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Mono<GuildEmoji> getGuildEmojiById(Snowflake guildId, Snowflake emojiId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @Cacheable(cacheNames="mono")
    public Mono<Member> getMemberById(Snowflake guildId, Snowflake userId) {
        LOG.info("gatewayService getMemberById no hit!");
        return gateway.getMemberById(guildId, userId);
    }

    @Override
    public Mono<Message> getMessageById(Snowflake channelId, Snowflake messageId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Mono<Role> getRoleById(Snowflake guildId, Snowflake roleId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Mono<User> getUserById(Snowflake userId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Flux<Guild> getGuilds() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Mono<User> getSelf() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Flux<Member> getGuildMembers(Snowflake guildId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Flux<GuildChannel> getGuildChannels(Snowflake guildId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Flux<Role> getGuildRoles(Snowflake guildId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Flux<GuildEmoji> getGuildEmojis(Snowflake guildId) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
