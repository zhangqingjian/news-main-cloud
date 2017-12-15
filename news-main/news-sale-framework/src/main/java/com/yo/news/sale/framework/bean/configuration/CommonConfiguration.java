/**
 * 
 */
package com.yo.news.sale.framework.bean.configuration;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.yo.base.utils.base.MyString;
import com.yo.news.sale.framerwork.web.filter.FilterToRecordRequestInfoToContextFilter;
import com.yo.news.sale.framework.aspect.RequestIdStuffAspect;
import com.yo.news.sale.framework.aspect.RequestInvalidValidatorAspect;
import com.yo.news.sale.framework.aspect.RequestLoggingAspect;
import com.yo.news.sale.framework.enums.StatusCode;
import com.yo.news.sale.framework.redis.RedisTemplateBean;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

/**
*/
/**
 * @author JAN
 * @CreatedTime：2017年10月11日 上午10:05:11 说明：
 */
@Configuration
@EnableConfigurationProperties({ RedisProperties.class })
public class CommonConfiguration
{
	@Bean
	public FilterToRecordRequestInfoToContextFilter filterToRecordRequestInfoToContextFilter()
	{
		return new FilterToRecordRequestInfoToContextFilter();
	}

	@Bean
	public RequestIdStuffAspect requestIdStuffAspect()
	{
		return new RequestIdStuffAspect(Byte.MAX_VALUE);
	}

	@Bean
	public RequestLoggingAspect requestLoggingAspect()
	{
		return new RequestLoggingAspect(Byte.MAX_VALUE + 1);
	}

	@Bean
	public RequestInvalidValidatorAspect requestInvalidValidatorAspect()
	{
		return new RequestInvalidValidatorAspect(Byte.MAX_VALUE + 2, StatusCode.INVALID_MODEL_FIELDS);
	}

	@Bean
	public JedisCluster getJedisCluster(RedisProperties redisProperties)
	{
		Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		String nodes = redisProperties.getNodes();
		String[] hostPortList = nodes.split(",");

		for (int i = 0; i < hostPortList.length; i++)
		{
			String[] hostPort = hostPortList[i].split(":");
			if (hostPort.length < 2)
			{
				throw new RuntimeException("invalid redis config,redis node config is " + redisProperties.toString());
			}
			jedisClusterNodes.add(new HostAndPort(hostPort[0], Integer.valueOf(hostPort[1])));
		}
		jedisPoolConfig.setMinIdle(redisProperties.getMinIdle());
		jedisPoolConfig.setMaxIdle(redisProperties.getMaxIdle());
		jedisPoolConfig.setMaxWaitMillis(redisProperties.getMaxWaitMillis());
		jedisPoolConfig.setMaxTotal(redisProperties.getMaxTotal());
		jedisPoolConfig.setTestOnBorrow(redisProperties.isTestOnBorrow());
		jedisPoolConfig.setTestOnReturn(redisProperties.isTestOnReturn());
		jedisPoolConfig.setTestWhileIdle(redisProperties.isTestWhileIdle());
		JedisCluster jedisCluster = new JedisCluster(jedisClusterNodes, jedisPoolConfig);
		return jedisCluster;
	}
}
