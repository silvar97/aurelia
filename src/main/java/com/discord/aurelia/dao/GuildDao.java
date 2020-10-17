package com.discord.aurelia.dao;

import java.util.List;

import discord4j.common.util.Snowflake;
import discord4j.core.object.entity.Guild;

public interface GuildDao {
    
    public List<Guild> getGuild(String guildName);
    public Guild getGuild(Snowflake guildId);

}
