
<<<<<<< HEAD:src/main/java/com/discord/aurelia/event/EmojiHandler.java
package com.discord.aurelia.event;
=======

package com.discord.aurelia.handler;
>>>>>>> bc000ed55d2fe21090b516b909539295f1b963f5:src/main/java/com/discord/aurelia/handler/EmojiHandler.java

import com.discord.aurelia.command.CommandInterface;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import discord4j.core.event.domain.Event;
import discord4j.core.event.domain.guild.EmojisUpdateEvent;

@Component
@Order(1)
public class EmojiHandler<T extends EmojisUpdateEvent> implements CommandInterface {

        public void handle(EmojisUpdateEvent event) {

        }

        @Override
        public void execute(Event event) {
                System.out.println("emojiHandler richtig");

        }

        @Override
        public String description() {
                // TODO Auto-generated method stub
                return null;
        }

}