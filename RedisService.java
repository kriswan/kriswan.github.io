package com.qunar.flight.ff.interline.service;

import com.qunar.redis.storage.Sedis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by kriswan on 6/2/16.
 * redis服务封装
 */package com.qunar.flight.ff.interline.service;

import com.qunar.redis.storage.Sedis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by kriswan on 6/2/16.
 * redis服务封装
 */
@Service
public class RedisService {

private static final Logger logger = LoggerFactory.getLogger(RedisService.class);

@Resource
Sedis redisClient;

/**
 * 判断是否存在key,存在返回false,不存在返回true,同时设置过期时间
 * @param key 航线key
 * @param value 结果UUID
 * @param expireSeconds key过期时间
 * @return true 设置成功, false 已经存在,设置失败
 */
public boolean setNxExp(String key, String value,int expireSeconds) {
        logger.info("redis setnx key={} ,value={}", key, value);
        try {
                Long ok = redisClient.setnx(key, value);
                if(ok == 1) {
                        expire(key, expireSeconds);//设置key的过期时间,即缓存过期时间
                }
                return (ok == 1);
        } catch (Exception e) {
                logger.error("redis setnx Error", e);
        }
        return false;
}

/**
 * 设置key seconds后失效
 *
 * @param key
 * @param seconds
 * @return 1: the timeout was set. 0 .key not exists .-1 unknow
 */
public Long expire(String key, int seconds) {
        logger.info("redis expire key={},seconds={}", key, seconds);
        Long result = -1L;
        try {
                result = redisClient.expire(key, seconds);
        } catch (Exception e) {
                logger.error("redis expire Error new", e);
        }
        return result;
}

public String get(String key) {
        logger.info("redis get key={}", key);
        try {
                return redisClient.get(key);
        } catch (Exception e) {
                logger.error("redis get Error", e);
        }
        return null;
}

public void set(String key, String value) {
        logger.debug("redis set key={}", key, value);
        try {
                redisClient.set(key, value);
        } catch (Exception e) {
                logger.error("redis set Error", e);
        }
}
public boolean del(String key) {
        logger.info("redis del key={}", key);
        try {
                Long result = redisClient.del(key);
                if (null == result || result <= 0) {
                        return false;
                } else {
                        return true;
                }
        } catch (Exception e) {
                logger.error("redis_delError new", e);
        }
        return false;
}


}

@Service
public class RedisService {

private static final Logger logger = LoggerFactory.getLogger(RedisService.class);

@Resource
Sedis redisClient;

/**
 * 判断是否存在key,存在返回false,不存在返回true,同时设置过期时间
 * @param key 航线key
 * @param value 结果UUID
 * @param expireSeconds key过期时间
 * @return true 设置成功, false 已经存在,设置失败
 */
public boolean setNxExp(String key, String value,int expireSeconds) {
        logger.info("redis setnx key={} ,value={}", key, value);
        try {
                Long ok = redisClient.setnx(key, value);
                if(ok == 1) {
                        expire(key, expireSeconds);//设置key的过期时间,即缓存过期时间
                }
                return (ok == 1);
        } catch (Exception e) {
                logger.error("redis setnx Error", e);
        }
        return false;
}

/**
 * 设置key seconds后失效
 *
 * @param key
 * @param seconds
 * @return 1: the timeout was set. 0 .key not exists .-1 unknow
 */
public Long expire(String key, int seconds) {
        logger.info("redis expire key={},seconds={}", key, seconds);
        Long result = -1L;
        try {
                result = redisClient.expire(key, seconds);
        } catch (Exception e) {
                logger.error("redis expire Error new", e);
        }
        return result;
}

public String get(String key) {
        logger.info("redis get key={}", key);
        try {
                return redisClient.get(key);
        } catch (Exception e) {
                logger.error("redis get Error", e);
        }
        return null;
}

public void set(String key, String value) {
        logger.debug("redis set key={}", key, value);
        try {
                redisClient.set(key, value);
        } catch (Exception e) {
                logger.error("redis set Error", e);
        }
}
public boolean del(String key) {
        logger.info("redis del key={}", key);
        try {
                Long result = redisClient.del(key);
                if (null == result || result <= 0) {
                        return false;
                } else {
                        return true;
                }
        } catch (Exception e) {
                logger.error("redis_delError new", e);
        }
        return false;
}


}
