local litcord = require('litcord')
local client = litcord('TOKEN')

client:on('ready', function()
    print('Logged in as '..client.user.username)
end)

client:on('messageCreate', function(message)
    if message.clean == 'hello world' then
    message.channel.sendMessage('Hello, World! litcord!')
    end
end)

litcord:run()
