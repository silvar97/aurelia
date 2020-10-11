// package com.discord.aurelia.configuration;

// import java.util.concurrent.TimeUnit;

// import com.github.benmanes.caffeine.cache.Caffeine;

// import org.springframework.cache.CacheManager;
// import org.springframework.cache.caffeine.CaffeineCacheManager;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// @Configuration
// public class CacheManagerConfig {

// @Bean
// public CacheManager manageCache(){ 
//    Caffeine<Object,Object> caffeineBuilder= Caffeine.newBuilder()
//     .expireAfterAccess(10,TimeUnit.SECONDS)
//     .weakKeys().initialCapacity(100)
//     .recordStats().maximumSize(100);
//     CaffeineCacheManager cacheManager=new CaffeineCacheManager("CHANNELS","GUILDS");
//     cacheManager.setAllowNullValues(false);
//     cacheManager.setCaffeine(caffeineBuilder);
//     return cacheManager;
// }

// }
