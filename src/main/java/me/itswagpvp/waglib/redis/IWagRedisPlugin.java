package me.itswagpvp.waglib.redis;

import me.itswagpvp.waglib.redis.adapter.IConfigurationAdapter;
import me.itswagpvp.waglib.redis.models.MessageTransferObject;
import me.itswagpvp.waglib.redis.models.RedisConfiguration;

import java.util.List;
import java.util.logging.Logger;

/**
 * @author _ItsWagPvP
 * @since 1.0.0
 */
public interface IWagRedisPlugin {

    /**
     * Runs asynchronous task
     *
     * @param task Task to be run async
     */
    void runAsync(Runnable task);

    /**
     * Calls the corresponding events when message was received
     *
     * @param channel               Channel which received the message
     * @param messageTransferObject {@link MessageTransferObject} which was received
     */
    void onMessageReceived(String channel, MessageTransferObject messageTransferObject);

    /**
     * Returns logger object
     *
     * @return Logger instance of the current implementation
     */
    Logger logger();

    /**
     * Returns the {@link IConfigurationAdapter} implementation
     *
     * @return Implementation of {@link IConfigurationAdapter}
     */
    default IConfigurationAdapter getConfigAdapter() {
        return null;
    }

    /**
     * Loading RedisManager from config method
     */
    default void load() {
        // Close if RedisManager is already initialized
        if (RedisManager.getAPI() != null) {
            RedisManager.getAPI().close();
        }

        // Load the configuration file
        IConfigurationAdapter configAdapter = this.getConfigAdapter();
        if (!configAdapter.isSetup()) {
            return;
        }

        this.logger().info("config.yml loaded successfully!");

        // Load server identifier
        String serverIdentifier = configAdapter.getString("serverIdentifier", null);
        if (serverIdentifier == null) {
            serverIdentifier = "MySuperServer1";
            this.logger().info("Cannot load 'serverIdentifier' from config.yml! Using 'MySuperServer1'!");
        }

        // Construct RedisConfiguration
        RedisConfiguration redisConfiguration = new RedisConfiguration(
                configAdapter.getString("redis.hostname", "localhost"),
                configAdapter.getInt("redis.port", 6379),
                configAdapter.getString("redis.username", null),
                configAdapter.getString("redis.password", null),
                configAdapter.getBoolean("redis.ssl", false)
        );


        // Setup the RedisManager
        List<String> channels = configAdapter.getStringList("channels");

        // Initialize RedisManager object
        if (RedisManager.getAPI() == null) {
            RedisManager.init(this, serverIdentifier, redisConfiguration);
            if (channels.isEmpty()) {
                RedisManager.getAPI().setup();
                return;
            }

            String[] channelsArray = channels.toArray(new String[0]);
            RedisManager.getAPI().setup(channelsArray);
            return;
        }

        // Reload the RedisManager if already initialized
        RedisManager.getAPI().reload(serverIdentifier, redisConfiguration, true);
        if (!channels.isEmpty()) {
            String[] channelsArray = channels.toArray(new String[0]);
            RedisManager.getAPI().subscribe(channelsArray);
        }

    }

}
