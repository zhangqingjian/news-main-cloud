package com.yo.news.sale.framework.redis;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.yo.base.utils.base.MyString;

import redis.clients.jedis.JedisCluster;

/**
 * @author JAN
 * @CreatedTime：2015年5月29日 下午4:09:04 说明：
 */
public abstract class BaseCacheAgent<T extends Serializable>
{
	protected static final String DEFAULT_DATE_TIME_FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";
	protected static SimpleDateFormat dateFormat = new SimpleDateFormat(DEFAULT_DATE_TIME_FORMAT_PATTERN);
	@Autowired
	protected JedisCluster jedisCluster;

	protected ObjectsTranscoder<T> transcoder = new ObjectsTranscoder<>();

	public abstract String getCacheKey(String key);

	public T getEntity(String key)
	{
		byte[] objBytes = jedisCluster.get(key).getBytes();
		return transcoder.deserialize(objBytes);
	}

	public String setEntity(String key,T t )
	{
		return jedisCluster.set(key.getBytes(), transcoder.serialize(t));

	}

	protected void setExpire(String key, int seconds)
	{
		jedisCluster.expire( key, seconds);
	}

	/**
	 * @author JAN
	 * @CreatedTime：2017年1月19日 下午2:57:18 说明：//设置为0 ，立刻过期
	 * @param key
	 */
	public void expireNow(String key)
	{
		jedisCluster.expire(key, 0);
	}

	public abstract T getModel(String key) throws Exception;

	public abstract void setModel(T t) throws Exception;

	protected void putMap(Map<String, String> map, String field, String value)
	{
		if (MyString.IsNullOrEmpty(value) == false)
		{
			map.put(field, value);
		}
	}
}
