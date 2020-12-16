package com.discord.aurelia.event;

import com.discord.aurelia.command.CommandInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import discord4j.common.util.Snowflake;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.Event;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.reaction.ReactionEmoji;
import discord4j.rest.util.Color;



@Component
public class ReactionRoleAdding<T extends Event> implements CommandInterface {

    @Autowired
    private GatewayDiscordClient gateway;

    public void execute(Event event) {

        /*
         * Create object of MessageCreateEvent class
         */
        MessageCreateEvent msgCreateEvent = (MessageCreateEvent) event;

        msgCreateEvent.getMessage().delete().block();
        
        // if (msgCreateEvent.getMessage().getContent().equals("!rr-add")){
        //     msgCreateEvent.getMessage().getChannel().block().createMessage("Wie lange willst du mich ignorieren? <@373412895591235595>").block();
        //     return;
            
        // }else{
        // msgCreateEvent.getMessage().getChannel().block().createMessage("Time to steal Uncles stairs tonight?").block();
        // msgCreateEvent.getMessage().getChannel().block().getLastMessage().block().addReaction(ReactionEmoji.unicode("✅")).block();
        // msgCreateEvent.getMessage().getChannel().block().getLastMessage().block().addReaction(ReactionEmoji.unicode("❌")).block();  
        
        // String userName = String.format("%s", msgCreateEvent.getMessage().getContent());
        // msgCreateEvent.getMessage().getChannel().block().createMessage(userName).block();
        //}
        // msgCreateEvent.getMessage().getChannel().block().createMessage("Time to steal Uncles stairs tonight?").block();
        // msgCreateEvent.getMessage().getChannel().block().getLastMessage().block().addReaction(ReactionEmoji.unicode("✅")).block();
        // msgCreateEvent.getMessage().getChannel().block().getLastMessage().block().addReaction(ReactionEmoji.unicode("❌")).block();  
        // msgCreateEvent.getMessage().getChannel().block().getLastMessage().block().addReaction(ReactionEmoji.custom(Snowflake.of("785153085793763358") , ":Au_Yeet:", true));
       

         
       

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
    public String getDescription() {
        // TODO Auto-generated method stub
        return null;
    }

}