package com.discord.aurelia.event;

import java.time.Duration;

import com.discord.aurelia.command.CommandInterface;

import org.reactivestreams.Publisher;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import discord4j.core.event.domain.Event;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.channel.Channel;
import discord4j.core.object.entity.channel.VoiceChannel;
import discord4j.core.spec.VoiceChannelJoinSpec;
import discord4j.voice.VoiceConnection;
import reactor.core.publisher.Mono;

@Component
@Order(1)
public class VoiceChatHandler<T extends Event> implements CommandInterface {

    @Override
    public void execute(Event event) {

        MessageCreateEvent msg = (MessageCreateEvent) event;
        msg.getGuild().block().getChannels().collectList().block().stream().forEach(c ->System.out.println( c.getType()));
      VoiceChannel voiceChannel = (VoiceChannel) msg.getGuild().block().getChannels().collectList().block().get(3);
       VoiceConnection voiceConnection = voiceChannel.join(spec->{}).block();
    //    final Publisher<Boolean> voiceStateCounter = voiceChannel.getVoiceStates()
    //    .count()
    //    .map(count -> 1L == count);
    //    final Mono<Void> onDelay = Mono.delay(Duration.ofSeconds(10L))
    //   .filterWhen(ignored -> voiceStateCounter)
    //   .switchIfEmpty(Mono.never())
    //   .then();
     // voiceConnection.disconnect();
    }

    @Override
<<<<<<< HEAD
    public String getDescription() {
        // TODO Auto-generated method stub
        return null;
=======
    public String description() {
        // TODO Auto-generated method stub
        return "null";
>>>>>>> 0d5f21e072f08b2ded6de9a93a4adbd9975be18c
    }


    
}
