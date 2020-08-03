import discord

client = discord.Client()

@client.event
async def on_ready():
    print('Logged in as {0.name}#{0.discriminator}'.format(client))

@client.event
async def on_message(message):
    if message.content == "hello world":
        await message.channel.send('Hello, World! discord.py')

client.run('TOKEN')