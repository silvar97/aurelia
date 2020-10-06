package com.discord.aurelia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
public class AureliaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AureliaApplication.class, args);
	}


	

}
