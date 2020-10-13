package com.discord.aurelia;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;

import discord4j.core.GatewayDiscordClient;


@SpringBootApplication
@EnableCaching

public class AureliaApplication {
	
	public static void main(String[] args) {
	ApplicationContext context=SpringApplication.run(AureliaApplication.class, args);
	GatewayDiscordClient gateway=(GatewayDiscordClient)context.getBean("gateway");
	gateway.onDisconnect().block();

	String[] beans = context.getBeanDefinitionNames();
	Arrays.sort(beans);
	for (String bean : beans) {
		System.out.println(bean);
	}
	
	}
	
}
