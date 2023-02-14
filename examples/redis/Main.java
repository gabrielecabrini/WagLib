import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;

public class Main {

    private RedisImpl redisImpl;

    @Override
    public void onEnable() {
        String host = getConfig().getString("AntiAC.Redis.hostname", "localhost");
        int port = getConfig().getInt("AntiAC.Redis.port", 6379);
        RedisURI uri = RedisURI.create("redis://" + host + ":" + port + "/1?timeout=20s&clientName=AntiAC");
        redisImpl = new RedisImpl(RedisClient.create(uri));

        redisImpl.register();

        plugin.getRedis().getConnectionAsync(connection -> connection.publish("CHANNEL_NAME", "message");

    }

    @Override
    public void onDisable() {
        redisImpl.close();
    }

    public RedisImpl getRedis() {
        return redisImpl;
    }

}