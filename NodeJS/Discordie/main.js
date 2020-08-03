const Discordie = require("discordie"),
      Events = Discordie.Events,
      client = new Discordie()

client.Dispatcher.on(Events.GATEWAY_READY, () => {
    console.info(`Logged in as ${client.User.username}#${client.User.discriminator}!`);
});

client.Dispatcher.on(Events.MESSAGE_CREATE, (e) => {
    if (e.message.content === "hello world") return e.message.channel.sendMessage('Hello, world! Discordie!');
});

client.connect({ token: "TOKEN" });