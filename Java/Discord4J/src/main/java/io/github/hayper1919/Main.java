package io.github.hayper1919;

import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;

public class Main {

    public static void main(String[] args) {
        final DiscordClient client = DiscordClient.create("TOKEN");
        final GatewayDiscordClient gateway = client.login().block();

        if (gateway == null) return;

        gateway.on(MessageCreateEvent.class).subscribe(event -> {
            Message message = event.getMessage();
            if("hello world".equals(message.getContent())) {
                MessageChannel channel = message.getChannel().block();
                if (channel == null) return;
                channel.createMessage("Hello, World! Discord4J!").block();
            }
        });

        gateway.onDisconnect().block();
    }

}