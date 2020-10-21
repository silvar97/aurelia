package com.discord.aurelia.dao;

import java.util.Optional;

import com.discord.aurelia.model.Warning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
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
        
       put(warning.getUser().getId().asLong(),warning);

    }

    @Override
    public Optional<Warning> getWarning(Warning warning) {
        return Optional.of(get(warning));
    }

    @Override
    public void removeWarning(Warning warning) {
        remove(warning);
    }

    @Override
    public boolean contains(Warning warning) {
        return get(warning)==null?false:true;
    }

    private void put(long id , Warning warning){
        cacheManager.getCache("warning").putIfAbsent(id,warning);
    }
    private Warning get(Warning warning){
        System.out.println(warning.getUser().getId().asLong());
        System.out.println(cacheManager.getCache("warning").get(warning.getUser().getId().asLong()));
        return (Warning) cacheManager.getCache("warning").get(warning.getUser().getId().asLong()).get();
    }
  private void remove(Warning warning){
    cacheManager.getCache("warning").evict(warning);
  }
}
