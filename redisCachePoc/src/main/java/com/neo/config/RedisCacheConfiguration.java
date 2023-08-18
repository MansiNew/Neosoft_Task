package com.neo.config;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

import com.neo.model.Student;

@Configuration
@EnableRedisRepositories
public class RedisCacheConfiguration {

	/* @Bean 
	    public static LettuceConnectionFactory redisConnectionFactory() {
	        LettuceConnectionFactory lcf = new LettuceConnectionFactory();
	        lcf.setHostName("localhost");
	        lcf.setPort(6379);		
	        lcf.afterPropertiesSet();
	        return lcf;
	    }*/
	@Bean

	JedisConnectionFactory jedisConnectionFactory() {
	    JedisConnectionFactory jedisConFactory
	      = new JedisConnectionFactory();
	    jedisConFactory.setHostName("localhost");
	    jedisConFactory.setPort(6379);
	    jedisConFactory.setTimeout(6000);
	    return jedisConFactory;
	}
	
	@Bean
	 public RedisTemplate<String, Student> redisTemplate() {
		    RedisTemplate<String, Student> redisTemplate = new RedisTemplate<String ,Student>();
		    redisTemplate.setConnectionFactory(jedisConnectionFactory());
		    redisTemplate.afterPropertiesSet();
		    return redisTemplate;
		}
	
}
