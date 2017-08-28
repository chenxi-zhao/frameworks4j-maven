package com.chenxi.jedis.dao;

/**
 * Created by zhaochx1 on 2016/11/24.
 *
 */
public interface BaseDao {
    public abstract <T> T get(String key, Class<T> c);

    public abstract <T> String set(String key, T value);
}

