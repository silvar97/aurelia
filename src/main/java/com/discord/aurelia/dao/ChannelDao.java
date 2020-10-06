package com.discord.aurelia.dao;

import java.util.Optional;

import discord4j.common.util.Snowflake;
import discord4j.core.object.entity.channel.Channel;

public interface ChannelDao {
    public Optional<Channel> getChannel(String channelName);
    public Optional<Channel> getChannel(Snowflake channelId);
}
