/**
 * 
 */
package com.yo.news.sale.pay.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.yo.news.sale.framework.web.ServletContextHolder;

import feign.Logger;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.codec.ErrorDecoder;

/**
*/
/**
 * @author JAN
 * @CreatedTime：2017年11月27日 下午3:49:23 说明：
 */
@Configuration
public class FeignConfiguration
{
	/** * 日志级别 * @return */
	@Bean
	Logger.Level feignLoggerLevel()
	{
		return Logger.Level.FULL;
	}

	@Primary
	@Bean
	public ErrorDecoder errorDecoder()
	{
		return new OrderFeignClientInvoidExceptionErrorDecoder();
	}

	/** * 创建Feign请求拦截器，在发送请求前设置认证的token,各个微服务将token设置到环境变量中来达到通用 * @return */
	@Bean
	public FeignBasicAuthRequestInterceptor basicAuthRequestInterceptor()
	{
		// System.out.println("ServletContextHolder.fetchRequestId()=" +
		// ServletContextHolder.fetchRequestId());
		return new FeignBasicAuthRequestInterceptor("");
	}
}
