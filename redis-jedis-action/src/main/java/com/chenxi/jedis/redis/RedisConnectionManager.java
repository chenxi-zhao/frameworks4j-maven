package com.chenxi.jedis.redis;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * @author zhaochx1
 *
 */
public class RedisConnectionManager {
    private static final Logger logger = Logger.getLogger(RedisConnectionManager.class);

    private static JedisPool connectionPool; // Single instance pool

    private static ShardedJedisPool shardedConnectionPool; // Sharded instance pool

    static ThreadLocal<Jedis> redisConnection = new ThreadLocal<Jedis>();
    static ThreadLocal<ShardedJedis> shardedConnection = new ThreadLocal<ShardedJedis>();

    public static boolean isSharded() {
        return shardedConnectionPool != null;
    }

    private static void  initConnectionPool(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-redis.xml");
        connectionPool =  (JedisPool) context.getBean("connectionPool");
    }

    static Jedis getRawConnectionInternal() {
        // Try to use a connection already leased in the request
        if (redisConnection.get() != null) {
            return redisConnection.get();
        }
        if(connectionPool == null){
            initConnectionPool();
        }

        Jedis jedis = connectionPool.getResource();
        redisConnection.set(jedis);
        return jedis;
    }

    public static Jedis getRawConnectionFromShard(String key) {
        return getRawConnectionFromShard((Object) key);
    }

    public static Jedis getRawConnectionFromShard(byte[] key) {
        return getRawConnectionFromShard((Object) key);
    }

    private static Jedis getRawConnectionFromShard(Object key) {
        if (!isSharded()) {
            return getRawConnectionInternal();
        }

        ShardedJedis sjedis = getRawShardedConnectionInternal();
        if (key instanceof String) {
            return sjedis.getShard((String) key);
        } else if (key instanceof byte[]) {
            return sjedis.getShard((byte[]) key);
        } else {
            logger.error("Get Redis Connection Error!");
        }
        return sjedis.getShard(key.toString());
    }

    /**
     * 获取分片的ShardedJedis实例
     *
     * @return ShardedJedis
     */
    static ShardedJedis getRawShardedConnectionInternal() {
        // Try to use a sharded connection already leased in the request
        if (shardedConnection.get() != null) {
            return shardedConnection.get();
        }
        if(shardedConnectionPool == null){
            initConnectionPool();
        }

        ShardedJedis sjedis = shardedConnectionPool.getResource();
        shardedConnection.set(sjedis);
        return sjedis;
    }

    /**
     * Close the last connection that was leased.
     */
    public static void closeConnection() {
        if (redisConnection.get() != null) {
            redisConnection.get().close();
            redisConnection.remove();
        } else if (shardedConnection.get() != null) {
            shardedConnection.get().close();
            shardedConnection.remove();
        }
    }

    /**
     * Destroy the connection pool.
     */
    public static void destroy() {
        if (!isSharded()) {
            connectionPool.destroy();
        } else {
            shardedConnectionPool.destroy();
        }
    }
}
