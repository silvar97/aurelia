package com.discord.aurelia;

import java.sql.Date;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.discord.aurelia.event.CustomEventDispatcher;
import com.discord.aurelia.model.Ban;
import com.discord.aurelia.model.CustomGuild;
import com.discord.aurelia.model.CustomUser;
import com.discord.aurelia.repository.BanRepository;
import com.discord.aurelia.repository.CustomUserRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;

import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.Event;


@SpringBootApplication
@EnableCaching
public class AureliaApplication {


	public static void main(String[] args) {
	ApplicationContext context=SpringApplication.run(AureliaApplication.class, args);
	GatewayDiscordClient gateway=(GatewayDiscordClient)context.getBean("gateway");
	CustomEventDispatcher<Event> customEventDispatcher = (CustomEventDispatcher<Event>)context.getBean("customEventDispatcher");
	BanRepository banRepo = (BanRepository)context.getBean("banRepository");
	CustomUserRepository userRepo =(CustomUserRepository)context.getBean("customUserRepository");

	 
	
	 CustomUser customUser = new CustomUser();
		Set<Ban>  bans = new HashSet<>();
		Ban ban = new Ban();
		CustomGuild guild = new CustomGuild();
		guild.setGuildId(123213);
		ban.setGuild(guild);
		ban.setUser(customUser);
		ban.setDate(new Date(System.currentTimeMillis()));
		bans.add(ban);
	    customUser.setBans(bans);
		customUser.setUserId(23321);
	 //userRepo.save(customUser);

		banRepo.save(ban);
		


	gateway.getEventDispatcher().on(customEventDispatcher.getEventType()).subscribe(customEventDispatcher::execute);
	gateway.onDisconnect().block();

	String[] beans = context.getBeanDefinitionNames();
	Arrays.sort(beans);
	for (String bean : beans) {
		if(bean.contains("spring")|| bean.contains("org")){
			continue;
		}
		System.out.println(bean);
	}
	
	}
	
}
