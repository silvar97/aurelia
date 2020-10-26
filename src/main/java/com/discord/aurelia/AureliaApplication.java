package com.discord.aurelia;

import java.sql.Date;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.discord.aurelia.event.CustomEventDispatcher;
import com.discord.aurelia.model.Ban;
import com.discord.aurelia.model.BanKey;
import com.discord.aurelia.model.Guild;
import com.discord.aurelia.model.User;
import com.discord.aurelia.repository.BanRepository;
import com.discord.aurelia.repository.GuildRepository;
import com.discord.aurelia.repository.UserRepository;

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

	UserRepository userRepo = context.getBean(UserRepository.class);
	GuildRepository guildRepo = context.getBean(GuildRepository.class);
	BanRepository banRepo = context.getBean(BanRepository.class);

		User user = new User(123123l);
		Guild guild = new Guild(123123l);

		BanKey banKey = new BanKey(user.getUserId(),guild.getGuildId());
		Ban ban = new Ban (banKey,user,guild);
		userRepo.save(user);
		guildRepo.save(guild);
		banRepo.save(ban);

	
		

	// GatewayDiscordClient gateway=(GatewayDiscordClient)context.getBean("gateway");
	// CustomEventDispatcher<Event> customEventDispatcher = (CustomEventDispatcher<Event>)context.getBean("customEventDispatcher");
		


	// gateway.getEventDispatcher().on(customEventDispatcher.getEventType()).subscribe(customEventDispatcher::execute);
	// gateway.onDisconnect().block();

	// String[] beans = context.getBeanDefinitionNames();
	// Arrays.sort(beans);
	// for (String bean : beans) {
	// 	if(bean.contains("spring")|| bean.contains("org")){
	// 		continue;
	// 	}
	// 	System.out.println(bean);
	// }
	
	 }
	
}
