package com.discord.aurelia.dao;

import java.util.Optional;

import com.discord.aurelia.dao.ChannelDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import discord4j.common.util.Snowflake;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.object.entity.channel.Channel;

@Repository
public class ChannelDaoServiceImpl implements ChannelDao {

    @Autowired
    GatewayDiscordClient gateway;

    @Override
    public Optional<Channel> getChannel(String channelName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<Channel> getChannel(Snowflake channelId) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
