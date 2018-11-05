package org.calendar.jan.config;

import java.lang.reflect.Method;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;

/**
 * 配置redis缓存
 * @author xman
 *
 */
@Configuration
@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport {

	@Bean
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(factory);
		
		FastJsonRedisSerializer<Object> fjrs = new FastJsonRedisSerializer<Object>(Object.class);
		ParserConfig.getGlobalInstance().addAccept("org.calendar");
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(fjrs);
		template.setHashKeySerializer(new StringRedisSerializer());
		template.setHashValueSerializer(fjrs);
		template.afterPropertiesSet();
		
		return template;
	}

	@Bean
	public CacheManager cacheManager(RedisTemplate<String, Object> template) {
		RedisCacheManager manager = new RedisCacheManager(template);
		// 缺省缓存6小时
		manager.setDefaultExpiration(6 * 3600);
		return manager;
	}
	
	/********* key生成规则 ***********/
	
	@Bean
	public KeyGenerator strKey() {
		
		return new KeyGenerator() {
			
			@Override
			public Object generate(Object target, Method method, Object... params) {
				StringBuilder sb = new StringBuilder();
				// 使用简单类名
				sb.append(target.getClass().getSimpleName()).append(":");
				sb.append(method.getName());
				if(params != null && params.length > 0) {
					sb.append(":");
					int length = params.length - 1;
					for(int i = 0; i <= length; i++) {
						if(params[i] != null) {
							sb.append(params[i].toString());
						}
						if(i != length) {
							sb.append(":");
						}
					}
				}
				return sb.toString();
			}
		};
	}
	
	@Bean
	public KeyGenerator idKey() {
		
		return new KeyGenerator() {
			
			@Override
			public Object generate(Object target, Method method, Object... params) {
				StringBuilder sb = new StringBuilder();
				// 使用简单类名
				sb.append(target.getClass().getSimpleName()).append(":");
				sb.append(method.getName());
				// 获取对象id
				if(params != null && params.length > 0) {
					sb.append(":");
					int length = params.length - 1;
					for(int i = 0; i <= length; i++) {
						if(params[i] != null) {
							try {
								Method meth = params[i].getClass().getMethod("getId", null);
								sb.append(meth.invoke(params[i], null).toString());
							} catch(Exception e) {
								throw new RuntimeException("无法生成缓存Key", e);
							}
						}
						if(i != length) {
							sb.append(":");
						}
					}
				}
				return sb.toString();
			}
		};
	}
	
}
