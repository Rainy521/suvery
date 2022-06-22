package com.lwch.survey.utils;

import java.io.IOException;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.lwch.survey.model.Config;
import com.lwch.survey.service.ConfigService;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Lazy
@Component
public class JC implements InitializingBean{

    @Autowired
    private ConfigService configService;
    
    private JedisPool _jedisPool;
    
    public Jedis getJedisPoolResource() {
        return _jedisPool.getResource();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Config portConfig = configService.selectConfig("sys.redis.port");
        
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxWaitMillis(10 * 1000);
        config.setMaxIdle(1000);
        config.setTestOnBorrow(true);
        
        _jedisPool = new JedisPool(config, configService.selectConfig("sys.redis.host").getValue(), Integer.valueOf(portConfig.getValue()));
    }
    
    @PreDestroy
    public void destroy() throws IOException{
        _jedisPool.close();
    }
}
