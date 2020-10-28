package com.discord.aurelia.event;

import com.discord.aurelia.command.CommandInterface;
import com.discord.aurelia.constant.CommandConstant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

import discord4j.common.util.Snowflake;
import discord4j.core.GatewayDiscordClient;
import discord4j.rest.util.Color;
import discord4j.rest.util.Image.Format;
import reactor.core.Exceptions;
import discord4j.core.event.domain.Event;
import discord4j.core.event.domain.guild.GuildCreateEvent;
import discord4j.core.event.domain.guild.GuildEvent;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.Embed;
import discord4j.core.object.entity.Guild;
import discord4j.core.object.entity.Member;
import discord4j.core.object.entity.Role;
import discord4j.core.object.entity.User;
import discord4j.core.object.entity.channel.Channel;
import discord4j.core.object.entity.channel.MessageChannel;
import discord4j.core.spec.EmbedCreateSpec;

@Component
public class ServerInfoHandler<T extends Event> implements CommandInterface {

    @Autowired
    private GatewayDiscordClient gateway;

    public void execute(Event event) {

        /*
         * Create object of MessageCreateEvent class
         */
        MessageCreateEvent msgCreateEvent = (MessageCreateEvent) event;

        //GuildCreateEvent guildEvent = (GuildCreateEvent) event;

        String serverName = msgCreateEvent.getGuild().block().getName();
        String serverOwner = String.format("<@%s>\n",
        msgCreateEvent.getGuild().block().getOwnerId().asString());
        String serverRegion = msgCreateEvent.getGuild().block().getRegionId();

        //  String generalInfo = String.format("**Server Name**:  %s\n**Server Owner**:  <@%s>\n**Region**: %s\n",
        //  msgCreateEvent.getGuild().block().getName(),
        //  msgCreateEvent.getGuild().block().getOwnerId().asString(),
        //  msgCreateEvent.getGuild().block().getRegionId()
        //  //msgCreateEvent.getGuild().block().
        //  );
        
        if (msgCreateEvent.getMessage().getContent().equals("!server")) {
            msgCreateEvent.getMessage().getChannel().block().createEmbed(e -> {
                e.setColor(Color.DARK_GRAY);
                e.setThumbnail(msgCreateEvent.getGuild().block().getIconUrl(Format.PNG).get());
                e.addField("Server Name: ",serverName, true);
                e.addField("Server Owner: ", serverOwner, true);
                e.addField("Region: ", serverRegion, true);
                // e.addField("Number of Boosts", "Todo...", true);
                // e.addField("Members", "Todo...", true);
                // e.addField("Total Channels", "Todo...", true);
                e.setFooter("ServerID: " + msgCreateEvent.getGuild().block().getId().asString(), null);
                return;
            }).block();
        }
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return null;
    }

}