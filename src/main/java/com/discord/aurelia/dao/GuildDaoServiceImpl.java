
package com.discord.aurelia.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import discord4j.common.util.Snowflake;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.object.entity.Guild;

@Repository
public class GuildDaoServiceImpl implements GuildDao {

    
    @Autowired
    GatewayDiscordClient gateway;

    public GuildDaoServiceImpl(){

    }

    @Override //@Cache
    public Optional<Guild> getGuild(String guildName) {
        return null;
    }

    @Override //@Cache
    public Optional<Guild> getGuild(Snowflake guildId) {
        return null;
    }



    
}