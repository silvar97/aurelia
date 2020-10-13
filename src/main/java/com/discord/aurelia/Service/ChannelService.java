package com.discord.aurelia.Service;

import java.util.Optional;

import com.discord.aurelia.dao.ChannelDao;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import discord4j.common.util.Snowflake;
import discord4j.core.object.entity.channel.Channel;

@Service
@Order(2)
public class ChannelService {
    private final ChannelDao channelDao=null;

    public Optional<Channel> getChannelByName (String channelName){
        return channelDao.getChannel(channelName);
    }
    public Optional<Channel> getChannelById(Snowflake channelId){
        return channelDao.getChannel(channelId);
    }
    
}

