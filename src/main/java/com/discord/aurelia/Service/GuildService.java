package com.discord.aurelia.Service;

import java.util.List;

import com.discord.aurelia.dao.GuildDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import discord4j.common.util.Snowflake;
import discord4j.core.object.entity.Guild;

@Service
@Order(2)
public class GuildService {
    @Autowired
    private GuildDao guildDao;

    public List<Guild> getGuildByName(String guildName) {

        return guildDao.getGuild(guildName);
    }

    public Guild getChannelById(Snowflake guildId) {

        return guildDao.getGuild(guildId);
    }

}
