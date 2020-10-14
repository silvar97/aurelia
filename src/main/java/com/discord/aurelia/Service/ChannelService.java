package com.discord.aurelia.Service;

import java.util.List;

import com.discord.aurelia.dao.ChannelDao;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import discord4j.common.util.Snowflake;
import discord4j.core.object.entity.channel.Channel;
import discord4j.core.object.entity.channel.GuildChannel;

@Service
@Order(2)
public class ChannelService {
    private final ChannelDao channelDao=null;

    public List<GuildChannel> getChannelByName (String channelName){
        return null;//channelDao.getChannel(channelName);
    }
    public Channel getChannelById(Snowflake channelId){
        return channelDao.getChannel(channelId);
    }
    
}

