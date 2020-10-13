
package com.discord.aurelia.dao;

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
@CacheConfig(cacheNames = {"GUILDS"})
public class GuildDaoServiceImpl implements GuildDao {

    
   // @Autowired
    //GatewayDiscordClient gateway;

    public GuildDaoServiceImpl(){

    }

    @Override //@Cache
    @Cacheable(unless = "#result == null")
    public Optional<Guild> getGuild(String guildName) {
        return null;
    }

    @Override //@Cache
    @Cacheable(unless = "#result == null")
    public Optional<Guild> getGuild(Snowflake guildId) {
        return null;// Optional.ofNullable(gateway.getGuildById(guildId).block());
    }



    
}