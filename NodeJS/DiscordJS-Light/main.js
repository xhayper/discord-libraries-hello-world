const Discord = require('discord.js-light'),
      client = new Discord.Client();

client.on('ready', () => {
    console.info(`Logged in as ${client.user.tag}!`);
});

client.on('message', (msg) => {
    if (msg.content === 'hello world') return msg.channel.send('Hello, world! DiscordJS-Light!');
});

client.login('TOKEN');