package com.discord.aurelia.Service;

import java.util.Optional;

import com.discord.aurelia.dao.GuildDao;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import discord4j.common.util.Snowflake;
import discord4j.core.object.entity.Guild;

@Service
@Order(2)
public class GuildService {
        private final GuildDao guildDao = null;
        
        public Optional<Guild> getGuildByName (String guildName){

            return guildDao.getGuild(guildName);
        }
        public Optional<Guild> getChannelById(Snowflake guildId){
    
            return guildDao.getGuild(guildId);
        }

}
