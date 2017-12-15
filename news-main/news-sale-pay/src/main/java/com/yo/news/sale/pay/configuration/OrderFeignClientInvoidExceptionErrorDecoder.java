/**
 * 
 */
package com.yo.news.sale.pay.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.exception.HystrixBadRequestException;

import feign.Response;
import feign.codec.ErrorDecoder;

/**
*/
/**
 * @author JAN
 * @CreatedTime：2017年11月24日 上午10:07:04 说明：
 */
@Component
public class OrderFeignClientInvoidExceptionErrorDecoder implements feign.codec.ErrorDecoder
{
	@Override
	public Exception decode(String methodKey, Response response)
	{
		if (response.status() >= 400 && response.status() <= 499)
		{
			return new HystrixBadRequestException("不进入熔断计数了");
		}
		return feign.FeignException.errorStatus(methodKey, response);
	}

}
