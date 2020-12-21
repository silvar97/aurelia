package com.discord.aurelia.event;

import com.discord.aurelia.command.CommandInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import discord4j.core.GatewayDiscordClient;
import discord4j.rest.util.Color;
import discord4j.rest.util.Image.Format;
import discord4j.core.event.domain.Event;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.channel.Channel.Type;
import discord4j.core.object.presence.Status;

@Component
public class ServerInfoHandler<T extends Event> implements CommandInterface {

        @Autowired
        private GatewayDiscordClient gateway;

        public void execute(Event event) {

                /*
                 * Create object of MessageCreateEvent class
                 */
                MessageCreateEvent msgCreateEvent = (MessageCreateEvent) event;

                /*
                 * Collect server information
                 */
                String serverName = msgCreateEvent.getGuild().block().getName();
                String serverOwner = String.format("<@%s>\n",
                                msgCreateEvent.getGuild().block().getOwnerId().asString());
                String serverRegion = msgCreateEvent.getGuild().block().getRegion().block().getName();
                String totalChannel = String.format("Total Channels: %s\nTotal Categories: %s\nText: %s\nVoice: %s\n",
                                msgCreateEvent.getGuild().block().getChannels().collectList().block().size(),
                                msgCreateEvent.getGuild().block().getChannels().collectList().block().stream()
                                                .filter((c) -> c.getType() == Type.GUILD_CATEGORY).count(),
                                msgCreateEvent.getGuild().block().getChannels().collectList().block().stream()
                                                .filter((c) -> c.getType() == Type.GUILD_TEXT).count(),
                                msgCreateEvent.getGuild().block().getChannels().collectList().block().stream()
                                                .filter((c) -> c.getType() == Type.GUILD_VOICE).count());
                String serverMemberStats = String.format(
                                "Total Members: %s\nOnline Members: %s\nOffline Members: %s\nBots: %s\n",
                                msgCreateEvent.getGuild().block().getMemberCount(),
                                msgCreateEvent.getGuild().block().getMembers().collectList().block().stream()
                                                .filter((m) -> m.getPresence().block().getStatus() == Status.ONLINE)
                                                .count(),
                                msgCreateEvent.getGuild().block().getMembers().collectList().block().stream()
                                                .filter((m) -> m.getPresence().block().getStatus() == Status.OFFLINE)
                                                .count(),
                                msgCreateEvent.getGuild().block().getMembers().collectList().block().stream()
                                                .filter((m) -> m.isBot()).count());
                String serverTotalRoles = String.format("%s\n", msgCreateEvent.getGuild().block().getRoleIds().size());
                String numberOfBoosts = String.format("%s\n",
                                msgCreateEvent.getGuild().block().getPremiumSubscriptionCount().getAsInt());
                String levelOfBoosts = String.format("%s\n", msgCreateEvent.getGuild().block().getPremiumTier());
                LocalDateTime str = LocalDateTime.ofInstant(msgCreateEvent.getGuildId().get().getTimestamp(),
                                ZoneId.systemDefault());
                DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                /*
                 * Create embed and insert server information
                 */
                if (msgCreateEvent.getMessage().getContent().equals("!server-info")) {
                        msgCreateEvent.getMessage().getChannel().block().createEmbed(e -> {
                                e.setColor(Color.of(224, 102, 102));
                                e.setThumbnail(msgCreateEvent.getGuild().block().getIconUrl(Format.PNG).get());
                                e.addField("Server Name", serverName, true);
                                e.addField("Server Owner ", serverOwner, true);
                                e.addField("Region", serverRegion, true);
                                e.addField("Channel Information", totalChannel, true);
                                e.addField("Member Information", serverMemberStats, true);
                                e.addField("Total Roles", serverTotalRoles, true);
                                e.addField("Number Of Boosts", numberOfBoosts, true);
                                e.addField("Boost Level", levelOfBoosts, true);
                                e.setFooter("Server Created: " + str.format(format) + " | ServerID: "
                                                + msgCreateEvent.getGuild().block().getId().asString(), null);
                        }).block();
                }
        }

        @Override
        public String description() {
                // TODO Auto-generated method stub
                return null;
        }

}