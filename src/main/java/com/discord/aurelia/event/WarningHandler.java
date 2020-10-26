package com.discord.aurelia.event;

import com.discord.aurelia.Service.ChannelService;
import com.discord.aurelia.Service.WarningService;
import com.discord.aurelia.command.CommandInterface;
import com.discord.aurelia.constant.CommandConstant;
import com.discord.aurelia.model.Warning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import discord4j.common.util.Snowflake;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.Event;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Guild;
import discord4j.core.object.entity.User;

@Component
@Order(1)
public class WarningHandler<T extends Event> implements CommandInterface {

    @Autowired
    private WarningService warningService;
    @Autowired
    private GatewayDiscordClient gateway;
    @Autowired 
    private ChannelService channelSerive;
    @Override
    public void execute(Event event) {

        MessageCreateEvent msgEvent = (MessageCreateEvent)event;
        if(!msgEvent.getMessage().getContent().matches(CommandConstant.WARN_COMMAND_REGEX)){
            return;
        }
        String userId = msgEvent.getMessage().getContent().replaceAll(" +"," ").split(" ")[1].replaceAll("[^0-9]","");
        
        User user=gateway.getMemberById(msgEvent.getGuild().block().getId(), Snowflake.of(userId)).block();
        Guild guild = msgEvent.getGuild().block();
        Warning warning = new Warning(user,guild,1,3);

        warningService.addWarning(warning);
        
        warning = warningService.getWarning(warning);

        msgEvent.getMessage().getChannel().block().createMessage(user.getUsername()+" yes Motherfucker!").block();
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return "Warns a user.\n !warn <user> <reason:optional>";
    }
}
