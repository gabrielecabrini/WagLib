import io.lettuce.core.RedisClient;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.List;

public class RedisImpl extends RedisAbstract {

    public RedisImpl(RedisClient lettuceRedisClient) {
        super(lettuceRedisClient);
    }

    private final String CHANNEL_NAME = "CHANNEL_NAME";

    public void register() {
        getPubSubConnection(connection -> {
            connection.async().subscribe(CHANNEL_NAME);
            try {
                connection.addListener(new RedisPubSub<String, String>() {
                    @Override
                    public void message(String channel, String message) {
                        if (!channel.equals(CHANNEL_NAME)) return;

                        // Your code here

                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
    }
}