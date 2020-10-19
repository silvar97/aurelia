package com.discord.aurelia.dao;

import java.util.Optional;

import com.discord.aurelia.model.Warning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

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
        // TODO Auto-generated method stub

    }

    @Override
    public Optional<Warning> getWarning(Warning warning) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void removeWarning(Warning warning) {
        // TODO Auto-generated method stub
    }

    @Override
    public boolean contains(Warning warning) {
        // TODO Auto-generated method stub
        return false;
    }

  
}
