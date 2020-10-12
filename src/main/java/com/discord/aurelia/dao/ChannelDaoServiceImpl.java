package com.discord.aurelia.dao;

import java.util.Optional;

import com.discord.aurelia.configuration.AureliaBotConfig;
import com.discord.aurelia.configuration.CacheManagerConfig;
import com.discord.aurelia.dao.ChannelDao;
import com.github.benmanes.caffeine.cache.Cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import discord4j.common.util.Snowflake;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.object.entity.channel.Channel;

@Repository
public class ChannelDaoServiceImpl implements ChannelDao {

   // @Autowired
   // private GatewayDiscordClient gateway;

    public ChannelDaoServiceImpl(){
        System.out.println("ChannelDaoServiceImpl created");
    }

    @Override
    public Optional<Channel> getChannel(String channelName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @Cacheable
    public Optional<Channel> getChannel(Snowflake channelId) {
        //Optional<Channel> c =  Optional.ofNullable(gateway.getChannelById(channelId).block());
        return null;//c;
    }
    
}
