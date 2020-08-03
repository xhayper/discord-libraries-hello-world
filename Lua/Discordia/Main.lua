local discordia = require('discordia')
local client = discordia.Client()

client:on('ready', function()
	print('Logged in as '.. client.user.tag)
end)

client:on('messageCreate', function(message)
	if message.content == 'hello world' then
		message.channel:send('Hello, World! Discordia')
	end
end)

client:run('Bot TOKEN')