package com.discord.aurelia.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import discord4j.common.util.Snowflake;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.object.entity.channel.Channel;
import discord4j.core.object.entity.channel.GuildChannel;

@Service
@Order(3)
@CacheConfig(cacheNames = {"CHANNELS"})
public class ChannelDaoServiceImpl implements ChannelDao {

  
    private GatewayDiscordClient gateway;

    public ChannelDaoServiceImpl(){
        System.out.println("ChannelDaoServiceImpl created");
    }

    @Override
    public List<GuildChannel> getChannel(String channelName) {
       return   gateway.getGuilds().collectList().block().stream() //improvement for complexity https://stackoverflow.com/questions/52477960/java-8-stream-with-two-lists
        .map(g->g.getChannels())
        .flatMap(c->c.collectList()
        .block().stream()
        .filter(channel->channel.getName()
        .equals(channelName)))
        .collect(Collectors.toList());
    }

    @Override
    @Cacheable
    public Channel getChannel(Snowflake channelId) {
        return gateway.getChannelById(channelId).block();
    }

    @Autowired
    public void setGateway(GatewayDiscordClient gateway){
        this.gateway = gateway;
    }

    
    
}
