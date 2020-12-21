// package com.discord.aurelia.event;

// import com.discord.aurelia.command.CommandInterface;
// import com.discord.aurelia.temp.UserMessageMap;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;

// import discord4j.common.util.Snowflake;
// import discord4j.core.GatewayDiscordClient;
// import discord4j.core.event.domain.Event;
// import discord4j.core.event.domain.message.MessageCreateEvent;
// import discord4j.core.event.domain.message.ReactionAddEvent;
// import discord4j.core.event.domain.message.ReactionRemoveEvent;
// import discord4j.core.event.domain.role.RoleCreateEvent;
// import discord4j.core.object.entity.Message;
// import discord4j.core.object.reaction.ReactionEmoji;
// import discord4j.core.spec.EmbedCreateSpec;
// import discord4j.discordjson.json.EmbedData;
// import discord4j.discordjson.json.MessageData;
// import discord4j.rest.entity.RestChannel;
// import discord4j.rest.entity.RestMessage;
// import discord4j.rest.util.Color;
// import reactor.core.publisher.Mono;

// @Component
// public class CommandDescriptionHandler<T extends Event> implements CommandInterface {

//     @Autowired
//     private GatewayDiscordClient gateway;
//     @Autowired
//     private UserMessageMap userMap;
//     public void execute(Event event) {

//         /*
//          * Check which Event appears and create object
//          */

<<<<<<< HEAD
        if (event instanceof MessageCreateEvent) {
            MessageCreateEvent msgCreateEvent = (MessageCreateEvent) event;
            // msgCreateEvent.getMessage().getChannel().block().createEmbed(e -> {
            //     e.setColor(Color.of(224, 102, 102));
            //     e.setDescription("Habib ist...");
            // }).block();
           // msgCreateEvent.getMessage().addReaction(ReactionEmoji.unicode("1️⃣")).block();
            userMap.add(msgCreateEvent.getMessage().getId().asLong());
=======
//         // MIT GETMESSAGE LÄSST SICH DIE MESSAGE ALLEIN AUCH EDITIEREN

//         if (event instanceof MessageCreateEvent) {
//             MessageCreateEvent msgCreateEvent = (MessageCreateEvent) event;
//             // msgCreateEvent.getMessage().getChannel().block().createEmbed(e -> {
//             //     e.setColor(Color.of(224, 102, 102));
//             //     e.setDescription("Habib ist...");
//             // }).block();
//            // msgCreateEvent.getMessage().addReaction(ReactionEmoji.unicode("1️⃣")).block();
//             userMap.add(msgCreateEvent.getMessage().getId().asLong());
>>>>>>> 0d5f21e072f08b2ded6de9a93a4adbd9975be18c

//             RestChannel channel =gateway.getRestClient().getChannelById(msgCreateEvent.getMessage().getChannelId());
//             EmbedCreateSpec emd = new  EmbedCreateSpec();
//             emd.setColor(Color.of(224, 102, 102));
//             EmbedData emdData = EmbedData.builder().description("Habib ist....").build();
//             MessageData msgData=channel.createMessage(emdData).block();
//             RestMessage msg= channel.getRestMessage(Snowflake.of(msgData.id()));
//             gateway.getMessageById(msgCreateEvent.getMessage().getChannelId(),Snowflake.of(msgData.id())).block().addReaction(ReactionEmoji.unicode("1️⃣")).block();
//         }
//         if (event instanceof ReactionAddEvent) {
//             ReactionAddEvent reactionAddEvent = (ReactionAddEvent) event;
//             if (!reactionAddEvent.getMember().get().isBot()) {
//                 // reactionAddEvent.getChannel().block().getLastMessage().block()
//                 // .removeSelfReaction((ReactionEmoji.unicode("1️⃣"))).block();
//                 reactionAddEvent.getMessage().block().edit(e -> {
//                     e.setEmbed(m -> {
//                         m.setColor(Color.VIVID_VIOLET);
//                         m.setDescription("...ein Noob.");
//                     });
//                 }).block();
//             }
//         }
//         if (event instanceof ReactionRemoveEvent) {
//             ReactionRemoveEvent reactionRemoveEvent = (ReactionRemoveEvent) event;
//             reactionRemoveEvent.getMessage().block().edit(e -> {
//                 e.setEmbed(m -> {
//                     m.setColor(Color.of(224, 102, 102));
//                     m.setDescription("Habib ist...");
//                 });
//             }).block();
//         }
//     }

<<<<<<< HEAD
    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return null;
    }

}
=======
// }
>>>>>>> 0d5f21e072f08b2ded6de9a93a4adbd9975be18c
