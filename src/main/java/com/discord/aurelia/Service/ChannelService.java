package com.discord.aurelia.Service;

import java.util.List;

import com.discord.aurelia.dao.ChannelDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import discord4j.common.util.Snowflake;
import discord4j.core.object.entity.channel.Channel;
import discord4j.core.object.entity.channel.GuildChannel;

@Service
@Order(2)
public class ChannelService {
    @Autowired
    private ChannelDao channelDao;

    public List<GuildChannel> getChannelByName (String channelName){
        
        return channelDao.getChannel(channelName);
    }
    public Channel getChannelById(Snowflake channelId){
        return channelDao.getChannel(channelId);
    }
    
}

