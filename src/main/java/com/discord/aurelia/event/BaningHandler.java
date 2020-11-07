package com.discord.aurelia.event;

import com.discord.aurelia.command.CommandInterface;
import com.discord.aurelia.constant.CommandConstant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

import discord4j.common.util.Snowflake;
import discord4j.core.GatewayDiscordClient;
import discord4j.rest.util.Color;
import discord4j.core.event.domain.Event;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Member;
import discord4j.core.object.entity.Role;
import discord4j.core.object.entity.User;

@Component
public class BaningHandler<T extends Event> implements CommandInterface {

    @Autowired
    private GatewayDiscordClient gateway;

    public void execute(Event event) {

        /*
         * Create object of MessageCreateEvent class
         */
        MessageCreateEvent msgCreateEvent = (MessageCreateEvent) event;

        /*
         * Check if mentioned member is empty
         */
        if (!msgCreateEvent.getMessage().getContent().matches(CommandConstant.WARN_COMMAND_REGEX)) {
            msgCreateEvent.getMessage().getChannel().block().createEmbed(e -> {
                e.setColor(Color.RED);
                e.setDescription("Missing arguments.");
            }).block();
        }

        /*
         * Define user who mentioned another user
         */
        String mentionedUser = msgCreateEvent.getMessage().getContent().replaceAll(" +", " ").split(" ")[1]
                .replaceAll("[^0-9]", "");

        /*
         * Define user that GETS mentioned by another user
         */
        Member pingedUser = gateway.getMemberById(msgCreateEvent.getGuildId().get(), Snowflake.of(mentionedUser))
                .block();

        /*
         * Check if member who ran the command has permission do to so
         */

        List<Role> list = msgCreateEvent.getMember().get().getRoles().collectList().block();
        if (list.size() == 0) {
            return;
        }
        long permLongUser = list.get(0).getPermissions().getRawValue();
        boolean memberPermissionPresent = (permLongUser & 4) == 4;

        if (memberPermissionPresent == true) {
            pingedUser.ban(member -> {
                member.setReason("Noob");
                pingedUser.getPrivateChannel().block().createMessage(member.getReason()).block();
                msgCreateEvent.getMessage().getChannel().block().createEmbed(e -> {
                    e.setAuthor(msgCreateEvent.getMember().get().getUsername(),
                            msgCreateEvent.getMember().get().getDefaultAvatarUrl(),
                            msgCreateEvent.getMember().get().getAvatarUrl());
                    e.addField("**Banned**: ", pingedUser.getUsername(), true);
                    e.addField("**Reason**: ", "Test", true);
                    e.setColor(Color.RED);
                    e.setTimestamp(Instant.now());
                    return;
                }).block();
            }).block();
        } else {
            msgCreateEvent.getMessage().getChannel().block().createEmbed(e -> {
                e.setAuthor(msgCreateEvent.getMember().get().getUsername(),
                        msgCreateEvent.getMember().get().getDefaultAvatarUrl(),
                        msgCreateEvent.getMember().get().getAvatarUrl());
                e.setColor(Color.RED);
                e.addField("Permission missing", "You need the **Ban Member** permission to run this command.", true);
                return;
            }).block();
        }

        /*
         * Check if bot has the permission to ran the command
         */
        // long permLongBot =
        // msgCreateEvent.getGuild().block().getRoles().collectList().block().get(0).getPermissions()
        // .getRawValue();
        // boolean botPermissionPresent = (permLongBot & 4) == 4;

        // else if (botPermissionPresent == true){
        // pingedUser.ban(member -> {
        // member.setReason("Test");
        // pingedUser.getPrivateChannel().block().createMessage(member.getReason()).block();
        // msgCreateEvent.getMessage().getChannel().block()
        // .createMessage("The user: " + pingedUser.getUsername() + "\nGot banned from
        // this Server.").block();
        // }).block();

        /*
         * Ban member
         */
        // pingedUser.ban(member -> {
        // member.setReason("Stinker");
        // pingedUser.getPrivateChannel().block().createMessage(member.getReason()).block();
        // msgCreateEvent.getMessage().getChannel().block()
        // .createMessage(pingedUser.getUsername() + " got banned from this
        // Server!").block();
        // }).block();
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return "Bans a user from the server.\n !ban <@user> <reason> (optional)";
    }

}