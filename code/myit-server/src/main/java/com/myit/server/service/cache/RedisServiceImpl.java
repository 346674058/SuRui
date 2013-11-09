package com.myit.server.service.cache;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import com.myit.intf.service.cache.RedisService;

public class RedisServiceImpl implements RedisService {

    private static final Logger LOGGER = Logger.getLogger(RedisServiceImpl.class);

    private String host;
    private int port;

    JedisPool pool;
    Jedis jedis;

    private void init() {
        if (pool == null) {
            try {
                pool = new JedisPool(new JedisPoolConfig(), host, port);
                jedis = pool.getResource();
            } catch (Exception e) {
                LOGGER.error("jedis init falied", e);
            }
        }
    }

    public String get(String key) {
        if (jedis == null) {
            init();
        }

        try {
            return jedis.get(key);
        } catch (Exception e) {
            LOGGER.warn("get redis object failed,key=" + key, e);
        }
        return null;
    }

    public void set(String key, String value, int timeout) {
        if (jedis == null) {
            init();
        }

        try {
            jedis.set(key, value);
            jedis.expire(key, timeout);
        } catch (Exception e) {
            LOGGER.warn("set redis object failed,key=" + key + ", value=" + value, e);
        }

    }

    public void delete(String key) {
        if (jedis == null) {
            init();
        }

        try {
            jedis.del(key);
        } catch (Exception e) {
            LOGGER.warn("del redis object failed,key=" + key, e);
        }

    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

}
