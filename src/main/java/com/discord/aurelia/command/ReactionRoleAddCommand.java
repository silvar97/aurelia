package com.discord.aurelia.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.Event;
import discord4j.core.event.domain.message.MessageCreateEvent;

import org.springframework.stereotype.Component;

@Component
public class ReactionRoleAddCommand implements CommandInterface {

    @Autowired
    private GatewayDiscordClient gateway;

    public void execute(Event event) {

        /*
         * Create object of MessageCreateEvent class
         */
        MessageCreateEvent msgCreateEvent = (MessageCreateEvent) event;

        
    
       

         
       

        /*
         * Create embed for first setup step
         */

        // msgCreateEvent.getMessage().getChannel().block().createEmbed(e -> {
        // e.setColor(Color.DARK_GRAY);
        // e.setTitle("Reaction Roles - Setup part 1/3");
        // e.setDescription("In the first step you have to **tag the channel** (e.g. #ChannelName) in which the message that should receive the Reaction Roles is located.\n"
        // + "You have a time limit of 5 minutes to answer or the setup will be cancelled.\n\n"
        // + "You can stop the setup at any time by typing **cancel.**");
        // }).block();

        /*
         * Wait for user to tag channel
         */
        //Todo
        }
    @Override
    public String description() {
        return "null";
    }

}