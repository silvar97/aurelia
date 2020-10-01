package com.discord.aurelia;

import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.GatewayResources;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;


public class AureliaBot  {


   public static void startBot(){
    final String token = "NzYwNDY2MjczODIxMzkyODk2.X3MdaA.btlY8WQpwoB35mnziSNKj7kbg7g";
    final DiscordClient client = DiscordClient.create(token);
    final GatewayDiscordClient gateway = client.login().block();
    gateway.on(MessageCreateEvent.class).subscribe(event -> {
      final Message message = event.getMessage();
      if ("!ping".equals(message.getContent())) {
        final MessageChannel channel = message.getChannel().block();
        channel.createMessage("Pong!").block();
      }
    });
    
    gateway.onDisconnect().block();
  
   }
}
