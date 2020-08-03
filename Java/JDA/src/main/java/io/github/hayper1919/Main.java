package io.github.hayper1919;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import javax.security.auth.login.LoginException;

public class Main extends ListenerAdapter {

    public static void main(String[] args) throws LoginException {
        JDA jda = JDABuilder.createDefault("TOKEN").build();
        jda.addEventListener(new Main());
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        if (event.getMessage().getContentDisplay().equals("hello world")) event.getChannel().sendMessage("Hello, World! JDA!").queue();
    }

}