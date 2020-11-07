package com.discord.aurelia;

import java.sql.Date;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.discord.aurelia.event.CustomEventDispatcher;
import com.discord.aurelia.model.Ban;
import com.discord.aurelia.model.BanPK;
import com.discord.aurelia.repository.BanRepository;
import com.discord.aurelia.repository.GuildRepository;
import com.discord.aurelia.repository.UserRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import discord4j.common.util.Snowflake;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.Event;
import discord4j.core.object.ExtendedInvite;
import discord4j.core.object.Invite;
import discord4j.core.spec.InviteCreateSpec;
import discord4j.discordjson.json.InviteCreateRequest;
import discord4j.discordjson.json.gateway.InviteCreate;
import discord4j.rest.entity.RestInvite;
import discord4j.rest.service.InviteService;


@SpringBootApplication
@EnableCaching
@EnableScheduling
public class AureliaApplication {


	public static void main(String[] args) {
	ApplicationContext context=SpringApplication.run(AureliaApplication.class, args);



	// UserRepository userRepo = context.getBean(UserRepository.class);
	// GuildRepository guildRepo = context.getBean(GuildRepository.class);
	// BanRepository banRepo = context.getBean(BanRepository.class);

	// 	User user = new User(123123l);
	// 	Guild guild = new Guild(123123l);

	// 	BanKey banKey = new BanKey(user.getUserId(),guild.getGuildId());
	// 	Ban ban = new Ban (banKey,user,guild);
	// 	userRepo.save(user);
	// 	guildRepo.save(guild);
	// 	banRepo.save(ban);

	
		

	GatewayDiscordClient gateway=(GatewayDiscordClient)context.getBean("gateway");
	CustomEventDispatcher<Event> customEventDispatcher = (CustomEventDispatcher<Event>)context.getBean("customEventDispatcher");
		
		// gateway.getGuildById(Snowflake.of(759138832896884776l)).block().getInvites().collectList().block().759138832896884776
	gateway.getEventDispatcher().on(customEventDispatcher.getEventType()).subscribe(customEventDispatcher::execute);
	gateway.onDisconnect().block();

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
