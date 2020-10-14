package com.discord.aurelia.configuration;

import java.util.concurrent.TimeUnit;

import com.github.benmanes.caffeine.cache.Caffeine;

import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
@Order(4)
public class CacheManagerConfig {

    public CacheManagerConfig(){
        System.out.println("cacheconfig created");
    }

@Bean("cacheManager")
public CacheManager cacheManager(){ 
   Caffeine<Object,Object> caffeineBuilder= Caffeine.newBuilder()
    .expireAfterAccess(30,TimeUnit.SECONDS)
    .weakKeys().initialCapacity(100)
    .weakValues()
    .recordStats().maximumSize(100);
    CaffeineCacheManager cacheManager=new CaffeineCacheManager("CHANNELS","GUILDS");
    cacheManager.setAllowNullValues(false);
    cacheManager.setCaffeine(caffeineBuilder);
    return cacheManager;
}

}
