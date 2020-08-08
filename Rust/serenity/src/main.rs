use std::env;

use serenity::{
    model::{channel::Message, gateway::Ready},
    prelude::*,
};

struct Handler;

impl EventHandler for Handler {
    fn message(&self, ctx: Context, msg: Message) {
        if msg.content == "hello world" {
            if let Err(why) = msg.channel_id.say(&ctx.http, "Hello, world! Rust") {
                println!("Error sending message: {:?}", why);
            }
        }
    }

    fn ready(&self, _: Context, ready: Ready) {
        println!("Logged in as {}", ready.user.tag);
    }
}

fn main() {
    let token = env::var("TOKEN")
        .expect("Expected a token in the environment");

    let mut client = Client::new(&token, Handler).expect("Error creating client");

    if let Err(why) = client.start() {
        println!("Client error: {:?}", why);
    }
}
