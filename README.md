# WagLib 

[![](https://jitpack.io/v/ItsWagPvP/WagLib.svg)](https://jitpack.io/#ItsWagPvP/WagLib)

General Java API for Minecraft Development

# Redis

If you want to use Redis, be sure to implement correct classes if you're using Spigot/Bukkit or Bungee

## Main class example to load redis
 ```Java
import me.itswagpvp.waglib.redis.events.spigot.AsyncRedisMessageReceivedEvent;
import me.itswagpvp.waglib.redis.events.spigot.RedisMessageReceivedEvent;
import me.itswagpvp.waglib.redis.models.MessageTransferObject;
import me.itswagpvp.waglib.redis.models.RedisConfiguration;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Example extends JavaPlugin implements RedisPlugin {

    private RedisManager redisManager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        loadRedis();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        
        
        // You should close your Redis connection
        // This will also close every created thread
        redisManager.close();
        
    }

    public void loadRedis() {
        // Construct RedisConfiguration object
        RedisConfiguration redisConfiguration = new RedisConfiguration(
                "localhost", //hostname
                6379, //port
                null, //username (null if not any)
                null, //password (null if not any)
                false //ssl
        );

        // Initialize RedisManager instance (singleton)
        // Since init, use RedisManager#getAPI() to obtain the instance
        
        redisManager = new RedisManager(this, "server-identifier", redisConfiguration);

        // Now setup the connection
        redisManager.setup("channel1", "channel2", "channel3");

    }

    @Override
    public void onMessageReceived(String channel, MessageTransferObject messageTransferObject) {
        AsyncRedisMessageReceivedEvent asyncRedisMessageReceivedEvent = new AsyncRedisMessageReceivedEvent(channel, messageTransferObject);
        Bukkit.getPluginManager().callEvent(asyncRedisMessageReceivedEvent);

        if (asyncRedisMessageReceivedEvent.isCancelled()) {
            Bukkit.getScheduler().runTask(this, () -> Bukkit.getPluginManager().callEvent(new RedisMessageReceivedEvent(asyncRedisMessageReceivedEvent.getChannel(), asyncRedisMessageReceivedEvent.getMessageTransferObject())));
        }
    }

    @Override
    public Logger logger() {
        return this.getLogger();
    }

    public RedisManager getRedis() {
        return redisManager;
    }

}
 ```

## Register to Redis listener
 ```Java
 // Use bungee event import for BungeeCord!!!

import me.itswagpvp.waglib.redis.events.spigot.AsyncRedisMessageReceivedEvent;

public class MyListener implements Listener {

    @EventHandler
    public void onRedisMessageReceived(AsyncRedisMessageReceivedEvent event) {

        // Whether the message was sent by this server or not.
        // Uses the serverIdentifier from ForestRedisAPI config.yml
        boolean isSelfMessage = event.isSelfSender();

        // Name of the channel. Must be subscribed first.
        String channel = event.getChannel();

        // Identifier of the sender server.
        String senderServerId = event.getSenderIdentifier();
        
        // Date when the message was sent
        long timestamp = event.getTimeStamp();

        // Text of the message received.
        String messageText = event.getMessage();

        // Parses any object from JSON. Can be used instead of #getMessage()
        // Returns 'null' if it couldn't be parsed.
        MyObject myObject = event.getMessageObject(MyObject.class);

    }

}
 ```

## Send messages to Redis

 ```Java
 // For simple messages in String format use #publishMessage method.
RedisManager.getAPI().publishMessage("MyChannel1","Hello, how are you?");

// You can also publish any object. They'll be serialized using JSON.
RedisManager.getAPI().publishObject("MyChannel1",new MyObject());
 ```
