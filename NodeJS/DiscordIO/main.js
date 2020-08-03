const Discord = require('discord.io');
      client = new Discord.Client({
          token: "TOKEN",
          autorun: true
      });

client.on('ready', function() {
    console.info(`Logged in as ${client.username}#${client.discriminator}`);
});

client.on('message', function(user, userID, channelID, message) {
    if (message === "hello world") {
        client.sendMessage({
            to: channelID,
            message: "Hello, world! DiscordIO!"
        });
    }
});