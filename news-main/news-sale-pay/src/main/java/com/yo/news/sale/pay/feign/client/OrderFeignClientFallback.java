/**
 * 
 */
package com.yo.news.sale.pay.feign.client;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.yo.news.sale.pay.feign.client.request.ClientOrderTCCTryPayRequest;
import com.yo.news.sale.pay.feign.client.response.ClientOrderTCCTryPayResponse;

import io.swagger.annotations.ApiOperation;

/**
*/
/**
 * @author JAN
 * @CreatedTime：2017年11月15日 上午9:45:43 说明：
 */
@Component
public class OrderFeignClientFallback implements OrderFeignClient
{

	/**
	 * @author JAN
	 * @CreatedTime：2017年11月15日 上午9:56:47 说明：
	 * @param request
	 * @return
	 */
	@Override
	public ClientOrderTCCTryPayResponse tryPay(ClientOrderTCCTryPayRequest request)
	{
		System.out.println("OrderFeignClientFallback 调用tryPay 接口失败");
		return null;
	}

	@ApiOperation(value = "确认更新", notes = "TCC是先尝试更新，此处为确认")
	@RequestMapping(value = ORDER_TCC_PAY_URL + "/{orderId}")
	public void confirm(@PathVariable String orderId, HttpSession session)
	{
		System.out.println("OrderFeignClientFallback 调用confirm 接口失败");
	}
}
