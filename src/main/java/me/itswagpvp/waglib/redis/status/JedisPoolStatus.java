package me.itswagpvp.waglib.redis.status;

import redis.clients.jedis.JedisPool;

/**
 * @author _ItsWagPvP
 * @since 1.1.4
 * Interface for getting information about the Jedis pool
 */
@SuppressWarnings("unused")
public class JedisPoolStatus {

    private final JedisPool jedisPool;

    public JedisPoolStatus(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    /**
     * @return Number of active connections
     */
    public int getActiveCount() {
        return jedisPool.getNumActive();
    }

    /**
     * @return Number of idle connections
     */
    public int getIdleCount() {
        return jedisPool.getNumIdle();
    }

    /**
     * @return Number of waiting threads
     */
    public int getWaitersCount() {
        return jedisPool.getNumWaiters();
    }

    /**
     * @return Whether the pool is closed
     */
    public boolean isClosed() {
        return jedisPool.isClosed();
    }

}
