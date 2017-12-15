/**
 * 
 */
package com.yo.news.tcc.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.yo.news.sale.framework.redis.RedisTemplateBean;

/**
*/
/**
 * @author JAN
 * @CreatedTime：2017年10月18日 下午2:25:54 说明：
 */
@Configuration
public class BeanInitConfiguration
{
	@LoadBalanced
	@Bean
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}

	@Bean
	RedisTemplateBean getRedisTemplateBean()
	{
		return new RedisTemplateBean();
	}
}
