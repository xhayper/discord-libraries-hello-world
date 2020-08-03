private DiscordClient _client;

void Start()
{
    _client = new DiscordClient();
    _client.StartBot("Bot TOKEN", ClientConnected);
}

void ClientConnected(DiscordClient client, string result, DiscordError error)
{
   if (!error.failed)
   {
       Debug.Log("Logged in as " + client.user.username + "#" + client.user.discriminator);
       client.OnMessageCreated += MessageCreatedEvent;
       return;
   }
}

private void MessageCreatedEvent(object sender, DiscordMessageArgs e)
{
   if(e.message.content == "hello world")
   {
   e.message.channel.Send("Hello, World! DiscordUnity!");
   }
}

void Update()
{
   if (_client != null)
   {
      if (_client.isUpdatable)
      {
         _client.Update();
      }
   }
}