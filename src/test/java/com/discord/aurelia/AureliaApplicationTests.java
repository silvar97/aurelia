package com.discord.aurelia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import com.discord.aurelia.Service.GatewayService;
import com.discord.aurelia.event.WarningHandler;
import com.discord.aurelia.repository.BanRepository;
import com.discord.aurelia.repository.GuildRepository;
import com.discord.aurelia.repository.UserRepository;
import com.discord.aurelia.repository.WarningRepository;
import com.github.benmanes.caffeine.cache.Cache;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;

import discord4j.common.util.Snowflake;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.Event;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Guild;
import discord4j.core.object.entity.Member;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.User;
import discord4j.core.object.entity.channel.Channel;
import discord4j.core.retriever.EntityRetrievalStrategy;
import discord4j.gateway.ShardInfo;
import reactor.core.publisher.Mono;

@SpringBootTest
class AureliaApplicationTests {

	@Autowired
	UserRepository userRepo;
	@Autowired
	GuildRepository GuildRepository;
	@Autowired
	BanRepository banRepo;
	@Autowired 
	WarningRepository warningRepo;


	@Autowired
	GatewayDiscordClient gateway;
	Member member;
	Guild guild;
	Channel channel;
	MessageCreateEvent msgEvent;
	Message msg;
	ShardInfo shardInfo;
	@Autowired
	WarningHandler<Event> warningHandler;
	@Autowired
	private CacheManager cache;
	@Test
	void warningHandlerAndCacheTest() {

		msg = gateway.getMessageById(Snowflake.of(759388959754551296l), Snowflake.of(770967015551795200l)).block();
		member=gateway.getMemberById(Snowflake.of(759138832896884776l), Snowflake.of(190182419578617856l)).block();
		guild = gateway.getGuildById(Snowflake.of(759138832896884776l)).block();
		channel = gateway.getChannelById(Snowflake.of(759388959754551296l)).block();
		shardInfo = ShardInfo.create(0, 1);
		
		warningHandler.execute(new MessageCreateEvent(gateway, shardInfo, msg, guild.getId().asLong(), member));
		assertEquals(1,((Cache) cache.getCache("warning").getNativeCache()).stats().missCount());
		warningHandler.execute(new MessageCreateEvent(gateway, shardInfo, msg, guild.getId().asLong(), member));
		assertEquals(2,((Cache) cache.getCache("warning").getNativeCache()).stats().missCount());
		warningHandler.execute(new MessageCreateEvent(gateway, shardInfo, msg, guild.getId().asLong(), member));
		assertEquals(2,((Cache) cache.getCache("warning").getNativeCache()).stats().missCount());
		assertEquals(1,((Cache) cache.getCache("warning").getNativeCache()).stats().hitCount());
		warningHandler.execute(new MessageCreateEvent(gateway, shardInfo, msg, guild.getId().asLong(), member));
		assertEquals(3,((Cache) cache.getCache("warning").getNativeCache()).stats().missCount());
	}

	@Test
	void testDatabaseUser(){

	}
	

}