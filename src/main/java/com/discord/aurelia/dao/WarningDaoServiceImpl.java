package com.discord.aurelia.dao;

import java.util.Optional;

import com.discord.aurelia.model.Warning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import discord4j.common.util.Snowflake;
import discord4j.core.GatewayDiscordClient;

@Service
@Order(3)
public class WarningDaoServiceImpl implements WarningDao {

 
    @Autowired
    private GatewayDiscordClient gateway;
    @Autowired
    private CacheManager cacheManager;

    @Override
    public void addWarning(Warning warning) {
       put(warning);
    }

    @Override
    public Warning getWarning(Warning warning) {
        return get(warning);
    }

    @Override
    public void removeWarning(Warning warning) {
        remove(warning);
    }

    @Override
    public boolean contains(Warning warning) {
        return get(warning)==null?false:true;
    }

    private void put(Warning warning){
        cacheManager.getCache("warning").putIfAbsent(warning.getGuild().getId().asLong(),warning);
    }
    private Warning get(Warning warning){
        System.out.println(warning.getUser().getId().asLong());
        System.out.println(cacheManager.getCache("warning").get(warning.getGuild().getId().asLong()));
        ValueWrapper value;
        if((value=cacheManager.getCache("warning").get(warning.getGuild().getId().asLong()))==null) {
            return null;
        }

        return (Warning)value.get();
    }
  private void remove(Warning warning){
    cacheManager.getCache("warning").evictIfPresent(warning.getGuild().getId().asLong());
  }
}
