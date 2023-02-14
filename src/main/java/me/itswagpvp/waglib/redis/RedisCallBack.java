package me.itswagpvp.waglib.redis;

import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.pubsub.StatefulRedisPubSubConnection;

import javax.annotation.Nullable;

/**
 * @author _ItsWagPvP
 * @since 1.2
 */
@FunctionalInterface
public interface RedisCallBack<R> {
    @Nullable
    R useConnection(StatefulRedisConnection<String, String> connection);

    @FunctionalInterface
    interface Binary<T> {
        T useBinaryConnection(StatefulRedisConnection<String, Object> connection);
    }

    @FunctionalInterface
    interface PubSub {
        void useConnection(StatefulRedisPubSubConnection<String, String> connection);
        @FunctionalInterface
        interface Binary {
            void useConnection(StatefulRedisPubSubConnection<String, Object> connection);
        }
    }

}
