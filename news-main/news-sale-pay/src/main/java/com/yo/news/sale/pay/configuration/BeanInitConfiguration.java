/**
 * 
 */
package com.yo.news.sale.pay.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
	// @Bean
	// public RedisCluster getRedisCluster()
	// {
	//
	// }

	@Bean
	public RedisTemplateBean getRedisTemplateBean()
	{
		return new RedisTemplateBean();
	}

}
