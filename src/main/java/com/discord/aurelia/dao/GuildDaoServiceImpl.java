
package com.discord.aurelia.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import discord4j.common.util.Snowflake;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.object.entity.Guild;

@Service
@Order(3)
@CacheConfig(cacheNames = { "guild" })
public class GuildDaoServiceImpl implements GuildDao {

     @Autowired
    private GatewayDiscordClient gateway;

    public GuildDaoServiceImpl() {

    }

    @Override
    public List<Guild> getGuild(String guildName) {
        // TODO Auto-generated method stub
        return gateway.getGuilds().collectList().block().stream().filter(g-> g.getName().equals(guildName)).collect(Collectors.toList());
    }

    @Override
    @Cacheable
    public Guild getGuild(Snowflake guildId) {
        // TODO Auto-generated method stub
        return gateway.getGuildById(guildId).block();
    }

  



    
}