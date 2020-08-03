import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.lifecycle.ReadyEvent;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;
import discord4j.discordjson.json.UserData;

public class Main {

    public static void main(String[] args) {
        DiscordClient client = DiscordClient.create("TOKEN");
        GatewayDiscordClient gateway = client.login().block();

        if (gateway == null) return;

        gateway.on(ReadyEvent.class).subscribe(event -> {
            UserData botData = client.getSelf().block();
            if (botData != null) System.out.println("Logged in as " + botData.username() + "#" + botData.discriminator());
        });

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