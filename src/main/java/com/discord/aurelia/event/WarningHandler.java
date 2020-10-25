package com.discord.aurelia.event;

import com.discord.aurelia.Service.ChannelService;
import com.discord.aurelia.Service.GuildService;
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
import discord4j.core.object.entity.Member;
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
    @Autowired
    private GuildService guildService;

    @Override
    public void execute(Event event) {

        MessageCreateEvent msgEvent = (MessageCreateEvent) event;
        if (!msgEvent.getMessage().getContent().matches(CommandConstant.WARN_COMMAND_REGEX)) {
            msgEvent.getMessage().getChannel().block().createMessage("test").block();
            return;
        }
    
    //   long permlong= msgEvent.getMember().get().getRoles().collectList().block().get(0).getPermissions().getRawValue();
    //   boolean haspermission= (permlong & 4) == 4;

    //   if(haspermission == true){
    //       //ban user
    //   }
    //   else {
    //       return;
    //   }

    //      long permlong= msgEvent.getGuild().block().getRoles().collectList().block().get(0).getPermissions().getRawValue();
    //   boolean haspermission= (permlong & 4) == 4;
    //   if(haspermission == true){
    //       //ban user
    //   }
    //   else {
    //       return;
    //   }

        System.out.println(msgEvent.getMessage().getContent());

        String userId = msgEvent.getMessage().getContent().replaceAll(" +", " ").split(" ")[1].replaceAll("[^0-9]", "");



        Member user = gateway.getMemberById(msgEvent.getGuild().block().getId(), Snowflake.of(userId)).block();
       
        Guild guild = guildService.getChannelById(msgEvent.getGuildId().get());
        Warning warning = new Warning(user, guild, 1, 3);
        Warning tmp;
        if ((tmp = warningService.get(warning)) != null) {
            if (tmp.getCurrentWarnings() == tmp.getMaxWarnings()) {
                msgEvent.getMessage().getChannel().block()
                        .createMessage(user.getUsername() + "Time to get banned motherfucker!").block();
                // ban or mute
                warningService.remove(warning);
                // user.ban(spec->{
                //     spec.setReason("Du warst fresh also wirst du benannt");
                    
                // }).block();
            } else {
                tmp.setCurrentWarnings(tmp.getCurrentWarnings() + 1);
            }
        } else {
            warningService.add(warning);
        }
        // msgEvent.getMessage().getChannel().block().createEmbed(spec->{
        //     spec.addField("banned: "+" asdasda", "  a", false);
        // }).block();

    }

}
