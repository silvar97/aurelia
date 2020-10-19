package com.discord.aurelia.dao;

import java.util.List;

import discord4j.common.util.Snowflake;
import discord4j.core.object.entity.channel.Channel;
import discord4j.core.object.entity.channel.GuildChannel;

public interface ChannelDao {
    public List<GuildChannel> getChannel(String channelName);
    public Channel getChannel(Snowflake channelId); // optional to avoid NPE
}
