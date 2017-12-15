/**
 * 
 */
package com.yo.news.sale.pay.feign.client;

import javax.validation.Valid;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.feign.ribbon.FeignRibbonClientAutoConfiguration;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yo.news.sale.pay.configuration.FeignConfiguration;
import com.yo.news.sale.pay.feign.client.request.ClientOrderTCCTryPayRequest;
import com.yo.news.sale.pay.feign.client.response.ClientOrderTCCTryPayResponse;

import io.swagger.annotations.ApiOperation;

/**
*/
/**
 * @author JAN
 * @CreatedTime：2017年11月14日 上午11:19:29 说明：
 */
// @FeignClient(value = OrderFeignClient.SERVICE_ID)
@FeignClient(value = OrderFeignClient.SERVICE_ID, fallback = OrderFeignClientFallback.class, configuration = FeignConfiguration.class)
public interface OrderFeignClient
{
	public static final String SERVICE_ID = "news-sale-orders";
	final String ORDER_TCC_PAY_URL = "/news/order/v1/pay/tcc1";

	@ApiOperation(value = "更新订单为支付状态", notes = "该接口用于支付的时候更新订单的支付状态")
	@RequestMapping(value = ORDER_TCC_PAY_URL, method = RequestMethod.POST)
	public ClientOrderTCCTryPayResponse tryPay(@RequestBody ClientOrderTCCTryPayRequest request);
}
