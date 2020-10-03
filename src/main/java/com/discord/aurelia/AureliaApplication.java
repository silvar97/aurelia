package com.discord.aurelia;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AureliaApplication  implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(AureliaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/* final String token = "NzYwNDY2MjczODIxMzkyODk2.X3MdaA.btlY8WQpwoB35mnziSNKj7kbg7g";
        final DiscordClient client = DiscordClient.create(token);
        final GatewayDiscordClient gateway = client.login().block();
		EventListener<MessageCreateEvent> listener = new CustomListener<>();
		gateway.getEventDispatcher().on(listener.getEventType()).subscribe(listener::execute);
		gateway.onDisconnect().block();*/
	}

	

}
