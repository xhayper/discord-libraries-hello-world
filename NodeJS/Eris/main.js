const Eris = require('eris'),
      bot = new Eris('TOKEN');

bot.on('ready', () => {
    console.info(`Logged in as ${bot.user.username}#${bot.user.discriminator}!`);
});

bot.on('messageCreate', (msg) => {
    if (msg.content === 'hello') return bot.createMessage(msg.channel.id, 'Hello, world! Eris!');
});

bot.connect();