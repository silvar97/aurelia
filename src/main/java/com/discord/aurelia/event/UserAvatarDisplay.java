package com.discord.aurelia.event;

import com.discord.aurelia.command.CommandInterface;
import com.discord.aurelia.constant.CommandConstant;
import com.discord.aurelia.repository.WarningRepository;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import discord4j.common.util.Snowflake;
import discord4j.core.GatewayDiscordClient;
import discord4j.rest.util.Color;
import discord4j.rest.util.Image;
import discord4j.rest.util.Image.Format;
import discord4j.core.event.domain.Event;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Member;
import discord4j.core.object.entity.Role;
import discord4j.core.object.entity.User;
import discord4j.core.object.entity.channel.Channel.Type;
import discord4j.core.object.presence.Status;

@Component
public class UserAvatarDisplay<T extends Event> implements CommandInterface {

    @Autowired
    private GatewayDiscordClient gateway;

    public void execute(Event event) {

        /*
         * Create object of MessageCreateEvent class
         */
        MessageCreateEvent msgCreateEvent = (MessageCreateEvent) event;

        final Member pingedUser;

        if (msgCreateEvent.getMessage().getContent().split(" ").length > 1) {

            /*
             * Define user who mentioned another user
             */
            String mentionedUser = msgCreateEvent.getMessage().getContent().replaceAll(" +", " ").split(" ")[1]
                    .replaceAll("[^0-9]", "");

            /*
             * Define user that GETS mentioned by another user
             */
            pingedUser = gateway.getMemberById(msgCreateEvent.getGuildId().get(), Snowflake.of(mentionedUser)).block();

        } else {
            pingedUser = msgCreateEvent.getMember().get();
        }

        msgCreateEvent.getMessage().getChannel().block().createEmbed(e -> {
            e.setColor(Color.of(224, 102, 102));
            e.setTitle("Avatar of " + pingedUser.getTag());
            if (pingedUser.getId().asString().equals("760466273821392896")) {
                e.setDescription("You can find my Avatar [here](https://www.artstation.com/alqmia)");
            }
            e.setImage(pingedUser.getAvatarUrl() + "?size=512");
        }).block();

    }

    @Override
    public String description() {
        // TODO Auto-generated method stub
        return null;
    }

}
