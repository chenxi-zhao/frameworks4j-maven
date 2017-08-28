package com.chenxi.jedis.dao.impl;

import com.chenxi.jedis.dao.BaseDao;
import com.chenxi.jedis.redis.RedisCommand;
import com.chenxi.jedis.util.JsonUtil;
import org.apache.log4j.Logger;

/**
 * Created by zhaochx1 on 2016/11/24.
 *
 * @author zhaochx1
 */
public class BaseDaoImpl implements BaseDao {
    private static final Logger logger = Logger.getLogger(BaseDaoImpl.class);

    @Override
    public <T> T get(String key, Class<T> clazz) {
        String jsonString = RedisCommand.get(key);
        T value = JsonUtil.readValue(jsonString, clazz);
        logger.info(this.getClass().getName() +" : set--value:" +jsonString);
        return value;
    }

    @Override
    public <T> String set(String key, T value) {
        String json = JsonUtil.parseJson(value);
        String s = RedisCommand.set(key, json);
        logger.info(this.getClass().getName() +" : get--value:" +json);
        return s;
    }
}
