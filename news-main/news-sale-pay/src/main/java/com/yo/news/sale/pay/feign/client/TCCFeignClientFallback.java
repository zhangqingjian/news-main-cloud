/**
 * 
 */
package com.yo.news.sale.pay.feign.client;

import org.springframework.stereotype.Component;

import com.yo.news.sale.pay.feign.client.request.ClientTCCRequest;

/**
*/
/**
 * @author JAN
 * @CreatedTime：2017年11月15日 上午10:08:59 说明：
 */
@Component
public class TCCFeignClientFallback implements TCCFeignClient
{

	/**
	 * @author JAN
	 * @CreatedTime：2017年11月17日 下午1:35:12 说明：
	 * @param tccRequest
	 * @param result
	 * @param session
	 */
	public void confirm(ClientTCCRequest tccRequest)
	{
		System.out.println("TCCFeignClientFallback 的 confirm调用失败");
	}

	/**
	 * @author JAN
	 * @CreatedTime：2017年11月17日 下午1:35:12 说明：
	 * @param tccRequest
	 * @param result
	 * @param session
	 */
	public void cancel(ClientTCCRequest tccRequest)
	{
		System.out.println("TCCFeignClientFallback 的 cancel调用失败");
	}

}
