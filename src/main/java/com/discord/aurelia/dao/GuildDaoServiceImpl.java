
package com.discord.aurelia.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Repository;

import discord4j.common.util.Snowflake;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.object.entity.Guild;

@Repository
@Order(3)
@CacheConfig(cacheNames = { "guild" })
public class GuildDaoServiceImpl implements GuildDao {

     @Autowired
     GatewayDiscordClient gateway;

    public GuildDaoServiceImpl() {

    }

    @Override
    public List<Guild> getGuild(String guildName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Guild getGuild(Snowflake guildId) {
        // TODO Auto-generated method stub
        return null;
    }

  



    
}