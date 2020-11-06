package com.discord.aurelia.configuration;

import java.util.concurrent.TimeUnit;

import com.github.benmanes.caffeine.cache.Caffeine;

import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;

@Configuration
@Order(4)
@Lazy
public class CacheManagerConfig {

    public CacheManagerConfig(){
        System.out.println("cacheconfig created");
    }

@Bean("cacheManager")
@Lazy
public CacheManager cacheManager(){ 
   Caffeine<Object,Object> caffeineBuilder= Caffeine.newBuilder()
    .expireAfterAccess(5,TimeUnit.MINUTES)
    .initialCapacity(100)
    .recordStats().maximumSize(100);
    CaffeineCacheManager cacheManager=new CaffeineCacheManager("channel","guild","warning","mono","flux");
    cacheManager.setAllowNullValues(false);
    cacheManager.setCaffeine(caffeineBuilder);
    return cacheManager;
}

}
