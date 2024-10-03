package com.joseliza.bank.bootcoin.config;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

@Configuration
public class CacheConfig extends CachingConfigurerSupport{
	
	public static final String USER_CACHE = "walletbootcoin-cache";

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        Map<String, RedisCacheConfiguration> redisCacheConfigurationMap = new HashMap<>();
        redisCacheConfigurationMap.put(USER_CACHE, createConfig(60, ChronoUnit.MINUTES));

        return RedisCacheManager
            .builder(redisConnectionFactory)
            .withInitialCacheConfigurations(redisCacheConfigurationMap)
            .build();
    }

    private static RedisCacheConfiguration createConfig(long time, ChronoUnit temporalUnit) {
        return RedisCacheConfiguration.defaultCacheConfig()
            .entryTtl(Duration.of(time, temporalUnit));
    }

	
}
