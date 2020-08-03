package io.github.hayper1919;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class Main {

    public static void main(String[] args) {
        DiscordApi api = new DiscordApiBuilder().setToken("TOKEN").login().join();

        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equals("hello world")) event.getChannel().sendMessage("Hello, World! Javacord!");
        });
    }

}