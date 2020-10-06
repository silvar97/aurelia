package com.discord.aurelia.dao;

import java.util.Optional;

import discord4j.common.util.Snowflake;
import discord4j.core.object.entity.Guild;

public interface GuildDao {
    
    public Optional<Guild> getGuild(String guildName);
    public Optional<Guild> getGuild(Snowflake guildId);

}
