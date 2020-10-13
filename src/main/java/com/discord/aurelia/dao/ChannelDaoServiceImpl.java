package com.discord.aurelia.dao;

import java.util.Optional;

import com.discord.aurelia.configuration.AureliaBotConfig;
import com.discord.aurelia.configuration.CacheManagerConfig;
import com.discord.aurelia.dao.ChannelDao;
import com.github.benmanes.caffeine.cache.Cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import discord4j.common.util.Snowflake;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.object.entity.channel.Channel;

@Repository
@Order(3)
@CacheConfig(cacheNames = {"CHANNELS"})
public class ChannelDaoServiceImpl implements ChannelDao {

  
    private GatewayDiscordClient gateway;

    public ChannelDaoServiceImpl(){
        System.out.println("ChannelDaoServiceImpl created");
    }

    @Override
    public Optional<Channel> getChannel(String channelName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @Cacheable(value = "CHANNELS")
    public Optional<Channel> getChannel(Snowflake channelId) {
      Optional<Channel> c =  Optional.ofNullable(gateway.getChannelById(channelId).block());
        return c;
    }
    @Autowired
    public void setGateway(GatewayDiscordClient gateway){
        this.gateway = gateway;
    }
    
}
