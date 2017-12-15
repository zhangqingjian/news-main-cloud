/**
 * 
 */
package com.yo.news.sale.framework.redis;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.ScriptSource;
import org.springframework.stereotype.Repository;

import redis.clients.jedis.JedisCluster;
import redis.clients.util.SafeEncoder;

/**
*/
/**
 * @author JAN
 * @CreatedTime：2017年10月18日 下午1:51:15 说明：
 */
public class RedisTemplateBean
{
	@Autowired
	RedisTemplate redisTemplate;
	@Autowired
	JedisCluster jedisCluster;
	DefaultRedisScript<List<Long>> defaultRedisScript;

	//
	public void test()
	{
		List<String> arrayList = new ArrayList<>();
		List<String> arrayList2 = new ArrayList<>();
		arrayList.add("1");
		arrayList2.add("1");
		arrayList.add("2");

		List<Long> result = (List<Long>) jedisCluster.evalsha("c5809078fa6d652e0b0232d552a9d06d37fe819c", arrayList2, arrayList);
		jedisCluster.set("a", "12");
		System.out.println(jedisCluster.get("a"));
		// ValueOperations opsForValue = redisTemplate.opsForValue();
		// HashOperations h = redisTemplate.opsForHash();

	}

	private byte[][] getByteParams(String... params)
	{
		byte[][] p = new byte[params.length][];
		for (int i = 0; i < params.length; i++)
			p[i] = SafeEncoder.encode(params[i]);

		return p;
	}
}
