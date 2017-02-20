package com.chenxi.jedis.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisConnectionException;

/**
 * RedisCommand connector for the Play framework.
 *
 * **DO NOT EDIT**. This class was auto-generated. See
 * play.modules.redis.generator.RedisGenerator.
 *
 * @author Tim Kral
 **/
public class RedisCommand {
	/** 删除键 start**/
	public static Long del(byte[] key){
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.del(key);
	}

	public static Long del(String key){
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.del(key);
	}
	public static Long del(String[] keys) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.del(keys);
		} else {
			throw new JedisConnectionException("Cannot execute del with sharded instance.");
		}
	}

	public static Long del(byte[][] keys) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.del(keys);
		} else {
			throw new JedisConnectionException("Cannot execute del with sharded instance.");
		}
	}
	/** 删除键 end**/


	public static Long append(String key, String value) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.append(key, value);
	}

	public static Long append(byte[] key, byte[] value) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.append(key, value);
	}

	public static String auth(String password) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.auth(password);
		} else {
			throw new JedisConnectionException("Cannot execute auth with sharded instance.");
		}
	}

	public static String bgrewriteaof() {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.bgrewriteaof();
		} else {
			throw new JedisConnectionException("Cannot execute bgrewriteaof with sharded instance.");
		}
	}

	public static String bgsave() {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.bgsave();
		} else {
			throw new JedisConnectionException("Cannot execute bgsave with sharded instance.");
		}
	}

	public static java.util.List<String> blpop(int timeout, String[] keys) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.blpop(timeout, keys);
		} else {
			throw new JedisConnectionException("Cannot execute blpop with sharded instance.");
		}
	}

	public static java.util.List<byte[]> blpop(int timeout, byte[][] keys) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.blpop(timeout, keys);
		} else {
			throw new JedisConnectionException("Cannot execute blpop with sharded instance.");
		}
	}

	public static java.util.List<String> brpop(int timeout, String[] keys) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.brpop(timeout, keys);
		} else {
			throw new JedisConnectionException("Cannot execute brpop with sharded instance.");
		}
	}

	public static java.util.List<byte[]> brpop(int timeout, byte[][] keys) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.brpop(timeout, keys);
		} else {
			throw new JedisConnectionException("Cannot execute brpop with sharded instance.");
		}
	}

	public static byte[] brpoplpush(byte[] source, byte[] destination, int timeout) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.brpoplpush(source, destination, timeout);
		} else {
			throw new JedisConnectionException("Cannot execute brpoplpush with sharded instance.");
		}
	}

	public static String brpoplpush(String source, String destination, int timeout) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.brpoplpush(source, destination, timeout);
		} else {
			throw new JedisConnectionException("Cannot execute brpoplpush with sharded instance.");
		}
	}

	public static java.util.List<String> configGet(String pattern) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.configGet(pattern);
		} else {
			throw new JedisConnectionException("Cannot execute configGet with sharded instance.");
		}
	}

	public static String configResetStat() {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.configResetStat();
		} else {
			throw new JedisConnectionException("Cannot execute configResetStat with sharded instance.");
		}
	}

	public static String configSet(String parameter, String value) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.configSet(parameter, value);
		} else {
			throw new JedisConnectionException("Cannot execute configSet with sharded instance.");
		}
	}

	public static void connect() {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			jedis.connect();
		} else {
			throw new JedisConnectionException("Cannot execute connect with sharded instance.");
		}
	}

	public static Long dbSize() {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.dbSize();
		} else {
			throw new JedisConnectionException("Cannot execute dbSize with sharded instance.");
		}
	}

	public static String debug(redis.clients.jedis.DebugParams params) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.debug(params);
		} else {
			throw new JedisConnectionException("Cannot execute debug with sharded instance.");
		}
	}

	public static Long decr(byte[] key) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.decr(key);
	}

	public static Long decr(String key) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.decr(key);
	}

	public static Long decrBy(byte[] key, long integer) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.decrBy(key, integer);
	}

	public static Long decrBy(String key, long integer) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.decrBy(key, integer);
	}



	public static byte[] echo(byte[] string) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.echo(string);
		} else {
			throw new JedisConnectionException("Cannot execute echo with sharded instance.");
		}
	}

	public static String echo(String string) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.echo(string);
		} else {
			throw new JedisConnectionException("Cannot execute echo with sharded instance.");
		}
	}

	public static Boolean exists(String key) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.exists(key);
	}

	public static Boolean exists(byte[] key) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.exists(key);
	}

	public static Long expire(String key, int seconds) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.expire(key, seconds);
	}

	public static Long expire(byte[] key, int seconds) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.expire(key, seconds);
	}

	public static Long expireAt(byte[] key, long unixTime) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.expireAt(key, unixTime);
	}

	public static Long expireAt(String key, long unixTime) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.expireAt(key, unixTime);
	}

	public static String flushAll() {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.flushAll();
		} else {
			throw new JedisConnectionException("Cannot execute flushAll with sharded instance.");
		}
	}

	public static String flushDB() {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.flushDB();
		} else {
			throw new JedisConnectionException("Cannot execute flushDB with sharded instance.");
		}
	}

	public static String get(String key) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.get(key);
	}

	public static byte[] get(byte[] key) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.get(key);
	}

	public static redis.clients.jedis.Client getClient() {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.getClient();
		} else {
			throw new JedisConnectionException("Cannot execute getClient with sharded instance.");
		}
	}

	public static Long getDB() {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.getDB();
		} else {
			throw new JedisConnectionException("Cannot execute getDB with sharded instance.");
		}
	}

	public static byte[] getSet(byte[] key, byte[] value) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.getSet(key, value);
	}

	public static String getSet(String key, String value) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.getSet(key, value);
	}

	public static boolean getbit(String key, long offset) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.getbit(key, offset);
	}

	public static Boolean getbit(byte[] key, long offset) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.getbit(key, offset);
		} else {
			throw new JedisConnectionException("Cannot execute getbit with sharded instance.");
		}
	}

	public static String getrange(String key, long startOffset, long endOffset) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.getrange(key, startOffset, endOffset);
	}

	public static byte[] getrange(byte[] key, long startOffset, long endOffset) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.getrange(key, startOffset, endOffset);
		} else {
			throw new JedisConnectionException("Cannot execute getrange with sharded instance.");
		}
	}

	public static Long hdel(byte[] key, byte[] field) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.hdel(key, field);
	}

	public static Long hdel(String key, String field) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.hdel(key, field);
	}

	public static Boolean hexists(String key, String field) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.hexists(key, field);
	}

	public static Boolean hexists(byte[] key, byte[] field) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.hexists(key, field);
	}

	public static byte[] hget(byte[] key, byte[] field) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.hget(key, field);
	}

	public static String hget(String key, String field) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.hget(key, field);
	}

	public static java.util.Map hgetAll(String key) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.hgetAll(key);
	}

	public static java.util.Map hgetAll(byte[] key) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.hgetAll(key);
	}

	public static Long hincrBy(String key, String field, long value) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.hincrBy(key, field, value);
	}

	public static Long hincrBy(byte[] key, byte[] field, long value) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.hincrBy(key, field, value);
	}

	public static java.util.Set hkeys(byte[] key) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.hkeys(key);
	}

	public static java.util.Set hkeys(String key) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.hkeys(key);
	}

	public static Long hlen(String key) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.hlen(key);
	}

	public static Long hlen(byte[] key) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.hlen(key);
	}

	public static java.util.List hmget(String key, String[] fields) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.hmget(key, fields);
	}

	public static java.util.List hmget(byte[] key, byte[][] fields) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.hmget(key, fields);
	}

	@SuppressWarnings("unchecked")
	public static String hmset(String key, java.util.Map hash) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.hmset(key, hash);
	}

	@SuppressWarnings("unchecked")
	public static String hmset(byte[] key, java.util.Map hash) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.hmset(key, hash);
	}

	public static Long hset(byte[] key, byte[] field, byte[] value) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.hset(key, field, value);
	}

	public static Long hset(String key, String field, String value) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.hset(key, field, value);
	}

	public static Long hsetnx(String key, String field, String value) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.hsetnx(key, field, value);
	}

	public static Long hsetnx(byte[] key, byte[] field, byte[] value) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.hsetnx(key, field, value);
	}

	public static java.util.Collection hvals(byte[] x0) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(x0);
		return jedis.hvals(x0);
	}

	public static java.util.List hvals(String key) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.hvals(key);
	}

	public static Long incr(byte[] key) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.incr(key);
	}

	public static Long incr(String key) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.incr(key);
	}

	public static Long incrBy(String key, long integer) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.incrBy(key, integer);
	}

	public static Long incrBy(byte[] key, long integer) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.incrBy(key, integer);
	}

	public static String info() {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.info();
		} else {
			throw new JedisConnectionException("Cannot execute info with sharded instance.");
		}
	}

	public static boolean isConnected() {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.isConnected();
		} else {
			throw new JedisConnectionException("Cannot execute isConnected with sharded instance.");
		}
	}

	public static java.util.Set keys(byte[] pattern) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.keys(pattern);
		} else {
			throw new JedisConnectionException("Cannot execute keys with sharded instance.");
		}
	}

	public static java.util.Set keys(String pattern) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.keys(pattern);
		} else {
			throw new JedisConnectionException("Cannot execute keys with sharded instance.");
		}
	}

	public static Long lastsave() {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.lastsave();
		} else {
			throw new JedisConnectionException("Cannot execute lastsave with sharded instance.");
		}
	}

	public static byte[] lindex(byte[] key, int index) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.lindex(key, index);
	}

	public static String lindex(String key, long index) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.lindex(key, index);
	}

	public static Long linsert(byte[] key, redis.clients.jedis.BinaryClient.LIST_POSITION where, byte[] pivot,
			byte[] value) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.linsert(key, where, pivot, value);
	}

	public static Long linsert(String key, redis.clients.jedis.BinaryClient.LIST_POSITION where,
			String pivot, String value) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.linsert(key, where, pivot, value);
	}

	public static Long llen(byte[] key) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.llen(key);
	}

	public static Long llen(String key) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.llen(key);
	}

	public static String lpop(String key) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.lpop(key);
	}

	public static byte[] lpop(byte[] key) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.lpop(key);
	}

	public static Long lpush(String key, String string) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.lpush(key, string);
	}

	public static Long lpush(byte[] key, byte[] string) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.lpush(key, string);
	}

	public static Long lpushx(String key, String string) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.lpushx(key, string);
		} else {
			throw new JedisConnectionException("Cannot execute lpushx with sharded instance.");
		}
	}

	public static Long lpushx(byte[] key, byte[] string) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.lpushx(key, string);
		} else {
			throw new JedisConnectionException("Cannot execute lpushx with sharded instance.");
		}
	}

	public static java.util.List lrange(String key, long start, long end) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.lrange(key, start, end);
	}

	public static java.util.List lrange(byte[] key, int start, int end) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.lrange(key, start, end);
	}

	public static Long lrem(String key, long count, String value) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.lrem(key, count, value);
	}

	public static Long lrem(byte[] key, int count, byte[] value) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.lrem(key, count, value);
	}

	public static String lset(String key, long index, String value) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.lset(key, index, value);
	}

	public static String lset(byte[] key, int index, byte[] value) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.lset(key, index, value);
	}

	public static String ltrim(String key, long start, long end) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.ltrim(key, start, end);
	}

	public static String ltrim(byte[] key, int start, int end) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.ltrim(key, start, end);
	}

	public static java.util.List mget(byte[][] keys) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.mget(keys);
		} else {
			throw new JedisConnectionException("Cannot execute mget with sharded instance.");
		}
	}

	public static java.util.List mget(String[] keys) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.mget(keys);
		} else {
			throw new JedisConnectionException("Cannot execute mget with sharded instance.");
		}
	}

	public static void monitor(redis.clients.jedis.JedisMonitor jedisMonitor) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			jedis.monitor(jedisMonitor);
		} else {
			throw new JedisConnectionException("Cannot execute monitor with sharded instance.");
		}
	}

	public static Long move(String key, int dbIndex) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.move(key, dbIndex);
		} else {
			throw new JedisConnectionException("Cannot execute move with sharded instance.");
		}
	}

	public static Long move(byte[] key, int dbIndex) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.move(key, dbIndex);
		} else {
			throw new JedisConnectionException("Cannot execute move with sharded instance.");
		}
	}

	public static String mset(String[] keysvalues) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.mset(keysvalues);
		} else {
			throw new JedisConnectionException("Cannot execute mset with sharded instance.");
		}
	}

	public static String mset(byte[][] keysvalues) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.mset(keysvalues);
		} else {
			throw new JedisConnectionException("Cannot execute mset with sharded instance.");
		}
	}

	public static Long msetnx(String[] keysvalues) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.msetnx(keysvalues);
		} else {
			throw new JedisConnectionException("Cannot execute msetnx with sharded instance.");
		}
	}

	public static Long msetnx(byte[][] keysvalues) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.msetnx(keysvalues);
		} else {
			throw new JedisConnectionException("Cannot execute msetnx with sharded instance.");
		}
	}

	public static redis.clients.jedis.Transaction multi() {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.multi();
		} else {
			throw new JedisConnectionException("Cannot execute multi with sharded instance.");
		}
	}

	@SuppressWarnings("deprecation")
	public static java.util.List multi(redis.clients.jedis.TransactionBlock jedisTransaction) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.multi(jedisTransaction);
		} else {
			throw new JedisConnectionException("Cannot execute multi with sharded instance.");
		}
	}

	public static Long persist(byte[] key) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.persist(key);
		} else {
			throw new JedisConnectionException("Cannot execute persist with sharded instance.");
		}
	}

	public static Long persist(String key) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.persist(key);
		} else {
			throw new JedisConnectionException("Cannot execute persist with sharded instance.");
		}
	}

	public static String ping() {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.ping();
		} else {
			throw new JedisConnectionException("Cannot execute ping with sharded instance.");
		}
	}

	public static redis.clients.jedis.Pipeline pipelined() {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.pipelined();
		} else {
			throw new JedisConnectionException("Cannot execute pipelined with sharded instance.");
		}
	}

	@SuppressWarnings("deprecation")
	public static java.util.List pipelined(redis.clients.jedis.PipelineBlock jedisPipeline) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.pipelined(jedisPipeline);
		} else {
			throw new JedisConnectionException("Cannot execute pipelined with sharded instance.");
		}
	}

	public static void psubscribe(redis.clients.jedis.BinaryJedisPubSub jedisPubSub, byte[][] patterns) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			jedis.psubscribe(jedisPubSub, patterns);
		} else {
			throw new JedisConnectionException("Cannot execute psubscribe with sharded instance.");
		}
	}

	public static void psubscribe(redis.clients.jedis.JedisPubSub jedisPubSub, String[] patterns) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			jedis.psubscribe(jedisPubSub, patterns);
		} else {
			throw new JedisConnectionException("Cannot execute psubscribe with sharded instance.");
		}
	}

	public static Long publish(byte[] channel, byte[] message) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.publish(channel, message);
		} else {
			throw new JedisConnectionException("Cannot execute publish with sharded instance.");
		}
	}

	public static Long publish(String channel, String message) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.publish(channel, message);
		} else {
			throw new JedisConnectionException("Cannot execute publish with sharded instance.");
		}
	}

	public static byte[] randomBinaryKey() {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.randomBinaryKey();
		} else {
			throw new JedisConnectionException("Cannot execute randomBinaryKey with sharded instance.");
		}
	}

	public static String randomKey() {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.randomKey();
		} else {
			throw new JedisConnectionException("Cannot execute randomKey with sharded instance.");
		}
	}

	public static String rename(String oldkey, String newkey) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.rename(oldkey, newkey);
		} else {
			throw new JedisConnectionException("Cannot execute rename with sharded instance.");
		}
	}

	public static String rename(byte[] oldkey, byte[] newkey) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.rename(oldkey, newkey);
		} else {
			throw new JedisConnectionException("Cannot execute rename with sharded instance.");
		}
	}

	public static Long renamenx(byte[] oldkey, byte[] newkey) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.renamenx(oldkey, newkey);
		} else {
			throw new JedisConnectionException("Cannot execute renamenx with sharded instance.");
		}
	}

	public static Long renamenx(String oldkey, String newkey) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.renamenx(oldkey, newkey);
		} else {
			throw new JedisConnectionException("Cannot execute renamenx with sharded instance.");
		}
	}

	public static String rpop(String key) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.rpop(key);
	}

	public static byte[] rpop(byte[] key) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.rpop(key);
	}

	public static String rpoplpush(String srckey, String dstkey) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.rpoplpush(srckey, dstkey);
		} else {
			throw new JedisConnectionException("Cannot execute rpoplpush with sharded instance.");
		}
	}

	public static byte[] rpoplpush(byte[] srckey, byte[] dstkey) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.rpoplpush(srckey, dstkey);
		} else {
			throw new JedisConnectionException("Cannot execute rpoplpush with sharded instance.");
		}
	}

	public static Long rpush(byte[] key, byte[] string) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.rpush(key, string);
	}

	public static Long rpush(String key, String string) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.rpush(key, string);
	}

	public static Long rpushx(String key, String string) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.rpushx(key, string);
		} else {
			throw new JedisConnectionException("Cannot execute rpushx with sharded instance.");
		}
	}

	public static Long rpushx(byte[] key, byte[] string) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.rpushx(key, string);
		} else {
			throw new JedisConnectionException("Cannot execute rpushx with sharded instance.");
		}
	}

	public static Long sadd(String key, String member) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.sadd(key, member);
	}

	public static Long sadd(byte[] key, byte[] member) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.sadd(key, member);
	}

	public static String save() {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.save();
		} else {
			throw new JedisConnectionException("Cannot execute save with sharded instance.");
		}
	}

	public static Long scard(String key) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.scard(key);
	}

	public static Long scard(byte[] key) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.scard(key);
	}

	public static java.util.Set sdiff(byte[][] keys) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.sdiff(keys);
		} else {
			throw new JedisConnectionException("Cannot execute sdiff with sharded instance.");
		}
	}

	public static java.util.Set sdiff(String[] keys) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.sdiff(keys);
		} else {
			throw new JedisConnectionException("Cannot execute sdiff with sharded instance.");
		}
	}

	public static Long sdiffstore(String dstkey, String[] keys) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.sdiffstore(dstkey, keys);
		} else {
			throw new JedisConnectionException("Cannot execute sdiffstore with sharded instance.");
		}
	}

	public static Long sdiffstore(byte[] dstkey, byte[][] keys) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.sdiffstore(dstkey, keys);
		} else {
			throw new JedisConnectionException("Cannot execute sdiffstore with sharded instance.");
		}
	}

	public static String select(int index) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.select(index);
		} else {
			throw new JedisConnectionException("Cannot execute select with sharded instance.");
		}
	}

	public static String set(byte[] key, byte[] value) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.set(key, value);
	}

	public static String set(String key, String value) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.set(key, value);
	}

	public static Boolean setbit(byte[] key, long offset, byte[] value) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.setbit(key, offset, value);
		} else {
			throw new JedisConnectionException("Cannot execute setbit with sharded instance.");
		}
	}

	public static boolean setbit(String key, long offset, boolean value) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.setbit(key, offset, value);
	}

	public static String setex(String key, int seconds, String value) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.setex(key, seconds, value);
	}

	public static String setex(byte[] key, int seconds, byte[] value) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.setex(key, seconds, value);
	}

	public static Long setnx(String key, String value) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.setnx(key, value);
	}

	public static Long setnx(byte[] key, byte[] value) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.setnx(key, value);
	}

	public static long setrange(byte[] key, long offset, byte[] value) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.setrange(key, offset, value);
		} else {
			throw new JedisConnectionException("Cannot execute setrange with sharded instance.");
		}
	}

	public static long setrange(String key, long offset, String value) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.setrange(key, offset, value);
	}

	public static String shutdown() {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.shutdown();
		} else {
			throw new JedisConnectionException("Cannot execute shutdown with sharded instance.");
		}
	}

	public static java.util.Set sinter(String[] keys) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.sinter(keys);
		} else {
			throw new JedisConnectionException("Cannot execute sinter with sharded instance.");
		}
	}

	public static java.util.Set sinter(byte[][] keys) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.sinter(keys);
		} else {
			throw new JedisConnectionException("Cannot execute sinter with sharded instance.");
		}
	}

	public static Long sinterstore(String dstkey, String[] keys) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.sinterstore(dstkey, keys);
		} else {
			throw new JedisConnectionException("Cannot execute sinterstore with sharded instance.");
		}
	}

	public static Long sinterstore(byte[] dstkey, byte[][] keys) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.sinterstore(dstkey, keys);
		} else {
			throw new JedisConnectionException("Cannot execute sinterstore with sharded instance.");
		}
	}

	public static Boolean sismember(String key, String member) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.sismember(key, member);
	}

	public static Boolean sismember(byte[] key, byte[] member) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.sismember(key, member);
	}

	public static String slaveof(String host, int port) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.slaveof(host, port);
		} else {
			throw new JedisConnectionException("Cannot execute slaveof with sharded instance.");
		}
	}

	public static String slaveofNoOne() {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.slaveofNoOne();
		} else {
			throw new JedisConnectionException("Cannot execute slaveofNoOne with sharded instance.");
		}
	}

	public static java.util.Set smembers(byte[] key) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.smembers(key);
	}

	public static java.util.Set smembers(String key) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.smembers(key);
	}

	public static Long smove(byte[] srckey, byte[] dstkey, byte[] member) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.smove(srckey, dstkey, member);
		} else {
			throw new JedisConnectionException("Cannot execute smove with sharded instance.");
		}
	}

	public static Long smove(String srckey, String dstkey, String member) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.smove(srckey, dstkey, member);
		} else {
			throw new JedisConnectionException("Cannot execute smove with sharded instance.");
		}
	}

	public static java.util.List sort(String key) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.sort(key);
	}

	public static java.util.List sort(byte[] key) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.sort(key);
	}

	public static java.util.List sort(String key, redis.clients.jedis.SortingParams sortingParameters) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.sort(key, sortingParameters);
	}

	public static Long sort(String key, String dstkey) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.sort(key, dstkey);
		} else {
			throw new JedisConnectionException("Cannot execute sort with sharded instance.");
		}
	}

	public static java.util.List sort(byte[] key, redis.clients.jedis.SortingParams sortingParameters) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.sort(key, sortingParameters);
	}

	public static Long sort(byte[] key, byte[] dstkey) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.sort(key, dstkey);
		} else {
			throw new JedisConnectionException("Cannot execute sort with sharded instance.");
		}
	}

	public static Long sort(String key, redis.clients.jedis.SortingParams sortingParameters,
			String dstkey) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.sort(key, sortingParameters, dstkey);
		} else {
			throw new JedisConnectionException("Cannot execute sort with sharded instance.");
		}
	}

	public static Long sort(byte[] key, redis.clients.jedis.SortingParams sortingParameters, byte[] dstkey) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.sort(key, sortingParameters, dstkey);
		} else {
			throw new JedisConnectionException("Cannot execute sort with sharded instance.");
		}
	}

	public static String spop(String key) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.spop(key);
	}

	public static byte[] spop(byte[] key) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.spop(key);
	}

	public static String srandmember(String key) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.srandmember(key);
	}

	public static byte[] srandmember(byte[] key) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.srandmember(key);
	}

	public static Long srem(String key, String member) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.srem(key, member);
	}

	public static Long srem(byte[] key, byte[] member) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.srem(key, member);
	}

	public static Long strlen(String key) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.strlen(key);
		} else {
			throw new JedisConnectionException("Cannot execute strlen with sharded instance.");
		}
	}

	public static Long strlen(byte[] key) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.strlen(key);
		} else {
			throw new JedisConnectionException("Cannot execute strlen with sharded instance.");
		}
	}

	public static void subscribe(redis.clients.jedis.BinaryJedisPubSub jedisPubSub, byte[][] channels) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			jedis.subscribe(jedisPubSub, channels);
		} else {
			throw new JedisConnectionException("Cannot execute subscribe with sharded instance.");
		}
	}

	public static void subscribe(redis.clients.jedis.JedisPubSub jedisPubSub, String[] channels) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			jedis.subscribe(jedisPubSub, channels);
		} else {
			throw new JedisConnectionException("Cannot execute subscribe with sharded instance.");
		}
	}

	public static String substr(String key, int start, int end) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.substr(key, start, end);
	}

	public static byte[] substr(byte[] key, int start, int end) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.substr(key, start, end);
	}

	public static java.util.Set sunion(String[] keys) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.sunion(keys);
		} else {
			throw new JedisConnectionException("Cannot execute sunion with sharded instance.");
		}
	}

	public static java.util.Set sunion(byte[][] keys) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.sunion(keys);
		} else {
			throw new JedisConnectionException("Cannot execute sunion with sharded instance.");
		}
	}

	public static Long sunionstore(String dstkey, String[] keys) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.sunionstore(dstkey, keys);
		} else {
			throw new JedisConnectionException("Cannot execute sunionstore with sharded instance.");
		}
	}

	public static Long sunionstore(byte[] dstkey, byte[][] keys) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.sunionstore(dstkey, keys);
		} else {
			throw new JedisConnectionException("Cannot execute sunionstore with sharded instance.");
		}
	}

	public static void sync() {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			jedis.sync();
		} else {
			throw new JedisConnectionException("Cannot execute sync with sharded instance.");
		}
	}

	public static Long ttl(byte[] key) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.ttl(key);
	}

	public static Long ttl(String key) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.ttl(key);
	}

	public static String type(byte[] key) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.type(key);
	}

	public static String type(String key) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.type(key);
	}

	public static String unwatch() {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.unwatch();
		} else {
			throw new JedisConnectionException("Cannot execute unwatch with sharded instance.");
		}
	}

	public static String watch(byte[][] keys) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.watch(keys);
		} else {
			throw new JedisConnectionException("Cannot execute watch with sharded instance.");
		}
	}

	public static String watch(String[] keys) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.watch(keys);
		} else {
			throw new JedisConnectionException("Cannot execute watch with sharded instance.");
		}
	}

	public static Long zadd(byte[] key, double score, byte[] member) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.zadd(key, score, member);
	}

	public static Long zadd(String key, double score, String member) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.zadd(key, score, member);
	}

	public static Long zcard(byte[] key) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.zcard(key);
	}

	public static Long zcard(String key) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.zcard(key);
	}

	public static Long zcount(String key, double min, double max) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.zcount(key, min, max);
	}

	public static Long zcount(byte[] key, double min, double max) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.zcount(key, min, max);
	}

	public static Double zincrby(String key, double score, String member) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.zincrby(key, score, member);
	}

	public static Double zincrby(byte[] key, double score, byte[] member) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.zincrby(key, score, member);
	}

	public static Long zinterstore(byte[] dstkey, byte[][] sets) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.zinterstore(dstkey, sets);
		} else {
			throw new JedisConnectionException("Cannot execute zinterstore with sharded instance.");
		}
	}

	public static Long zinterstore(String dstkey, String[] sets) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.zinterstore(dstkey, sets);
		} else {
			throw new JedisConnectionException("Cannot execute zinterstore with sharded instance.");
		}
	}

	public static Long zinterstore(String dstkey, redis.clients.jedis.ZParams params,
			String[] sets) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.zinterstore(dstkey, params, sets);
		} else {
			throw new JedisConnectionException("Cannot execute zinterstore with sharded instance.");
		}
	}

	public static Long zinterstore(byte[] dstkey, redis.clients.jedis.ZParams params, byte[][] sets) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.zinterstore(dstkey, params, sets);
		} else {
			throw new JedisConnectionException("Cannot execute zinterstore with sharded instance.");
		}
	}

	public static java.util.Set zrange(byte[] key, int start, int end) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.zrange(key, start, end);
	}

	public static java.util.Set zrange(String key, int start, int end) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.zrange(key, start, end);
	}

	public static java.util.Set zrangeByScore(String key, String min, String max) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.zrangeByScore(key, min, max);
		} else {
			throw new JedisConnectionException("Cannot execute zrangeByScore with sharded instance.");
		}
	}

	public static java.util.Set zrangeByScore(byte[] key, double min, double max) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.zrangeByScore(key, min, max);
	}

	public static java.util.Set zrangeByScore(String key, double min, double max) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.zrangeByScore(key, min, max);
	}

	public static java.util.Set zrangeByScore(byte[] key, byte[] min, byte[] max) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.zrangeByScore(key, min, max);
		} else {
			throw new JedisConnectionException("Cannot execute zrangeByScore with sharded instance.");
		}
	}

	public static java.util.Set zrangeByScore(byte[] key, double min, double max, int offset, int count) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.zrangeByScore(key, min, max, offset, count);
	}

	public static java.util.Set zrangeByScore(String key, double min, double max, int offset, int count) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.zrangeByScore(key, min, max, offset, count);
	}

	public static java.util.Set zrangeByScoreWithScores(byte[] key, double min, double max) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.zrangeByScoreWithScores(key, min, max);
	}

	public static java.util.Set zrangeByScoreWithScores(String key, double min, double max) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.zrangeByScoreWithScores(key, min, max);
	}

	public static java.util.Set zrangeByScoreWithScores(String key, double min, double max, int offset,
			int count) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.zrangeByScoreWithScores(key, min, max, offset, count);
	}

	public static java.util.Set zrangeByScoreWithScores(byte[] key, double min, double max, int offset, int count) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.zrangeByScoreWithScores(key, min, max, offset, count);
	}

	public static java.util.Set zrangeWithScores(String key, int start, int end) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.zrangeWithScores(key, start, end);
	}

	public static java.util.Set zrangeWithScores(byte[] key, int start, int end) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.zrangeWithScores(key, start, end);
	}

	public static Long zrank(byte[] key, byte[] member) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.zrank(key, member);
	}

	public static Long zrank(String key, String member) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.zrank(key, member);
	}

	public static Long zrem(String key, String member) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.zrem(key, member);
	}

	public static Long zrem(byte[] key, byte[] member) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.zrem(key, member);
	}

	public static Long zremrangeByRank(String key, int start, int end) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.zremrangeByRank(key, start, end);
	}

	public static Long zremrangeByRank(byte[] key, int start, int end) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.zremrangeByRank(key, start, end);
	}

	public static Long zremrangeByScore(String key, double start, double end) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.zremrangeByScore(key, start, end);
	}

	public static Long zremrangeByScore(byte[] key, double start, double end) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.zremrangeByScore(key, start, end);
	}

	public static java.util.Set zrevrange(String key, int start, int end) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.zrevrange(key, start, end);
	}

	public static java.util.Set zrevrange(byte[] key, int start, int end) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.zrevrange(key, start, end);
	}

	public static java.util.Set zrevrangeByScore(String key, String max, String min) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.zrevrangeByScore(key, max, min);
		} else {
			throw new JedisConnectionException("Cannot execute zrevrangeByScore with sharded instance.");
		}
	}

	public static java.util.Set zrevrangeByScore(byte[] key, byte[] max, byte[] min) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.zrevrangeByScore(key, max, min);
		} else {
			throw new JedisConnectionException("Cannot execute zrevrangeByScore with sharded instance.");
		}
	}

	public static java.util.Set zrevrangeByScore(String key, double max, double min) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.zrevrangeByScore(key, max, min);
	}

	public static java.util.Set zrevrangeByScore(byte[] key, double max, double min) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.zrevrangeByScore(key, max, min);
	}

	public static java.util.Set zrevrangeByScore(String key, double max, double min, int offset, int count) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.zrevrangeByScore(key, max, min, offset, count);
	}

	public static java.util.Set zrevrangeByScore(byte[] key, double max, double min, int offset, int count) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.zrevrangeByScore(key, max, min, offset, count);
	}

	public static java.util.Set zrevrangeByScoreWithScores(String key, double max, double min) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.zrevrangeByScoreWithScores(key, max, min);
	}

	public static java.util.Set zrevrangeByScoreWithScores(byte[] key, double max, double min) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.zrevrangeByScoreWithScores(key, max, min);
	}

	public static java.util.Set zrevrangeByScoreWithScores(String key, double max, double min, int offset,
			int count) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.zrevrangeByScoreWithScores(key, max, min, offset, count);
	}

	public static java.util.Set zrevrangeByScoreWithScores(byte[] key, double max, double min, int offset, int count) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.zrevrangeByScoreWithScores(key, max, min, offset, count);
	}

	public static java.util.Set zrevrangeWithScores(String key, int start, int end) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.zrevrangeWithScores(key, start, end);
	}

	public static java.util.Set zrevrangeWithScores(byte[] key, int start, int end) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.zrevrangeWithScores(key, start, end);
	}

	public static Long zrevrank(byte[] key, byte[] member) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.zrevrank(key, member);
	}

	public static Long zrevrank(String key, String member) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.zrevrank(key, member);
	}

	public static Double zscore(String key, String member) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.zscore(key, member);
	}

	public static Double zscore(byte[] key, byte[] member) {
		Jedis jedis = RedisConnectionManager.getRawConnectionFromShard(key);
		return jedis.zscore(key, member);
	}

	public static Long zunionstore(byte[] dstkey, byte[][] sets) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.zunionstore(dstkey, sets);
		} else {
			throw new JedisConnectionException("Cannot execute zunionstore with sharded instance.");
		}
	}

	public static Long zunionstore(String dstkey, String[] sets) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.zunionstore(dstkey, sets);
		} else {
			throw new JedisConnectionException("Cannot execute zunionstore with sharded instance.");
		}
	}

	public static Long zunionstore(String dstkey, redis.clients.jedis.ZParams params,
			String[] sets) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.zunionstore(dstkey, params, sets);
		} else {
			throw new JedisConnectionException("Cannot execute zunionstore with sharded instance.");
		}
	}

	public static Long zunionstore(byte[] dstkey, redis.clients.jedis.ZParams params, byte[][] sets) {
		if (!RedisConnectionManager.isSharded()) {
			Jedis jedis = RedisConnectionManager.getRawConnectionInternal();
			return jedis.zunionstore(dstkey, params, sets);
		} else {
			throw new JedisConnectionException("Cannot execute zunionstore with sharded instance.");
		}
	}

}