/**
 * 
 */
package com.yo.news.sale.pay.feign.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yo.news.sale.pay.feign.client.request.ClientBillTryPayTCCRequest;
import com.yo.news.sale.pay.feign.client.response.ClientBillTryPayTCCResponse;

/**
*/
/**
 * @author JAN
 * @CreatedTime：2017年11月14日 上午11:19:15 说明：
 */
// @FeignClient(BillFeignClient.SERVER_ID)
// @FeignClient(value = BillFeignClient.SERVER_ID)
@FeignClient(value = BillFeignClient.SERVER_ID, fallback = BillFeignClientFallBack.class)
// @FeignClient(value = BillFeignClient.SERVER_ID )
public interface BillFeignClient
{
	public static final String SERVER_ID = "news-sale-bill";

	String API_PREFIX = "/news/order/v1/bill";

	@PostMapping(value = API_PREFIX + "/pay/tcc")
	public ClientBillTryPayTCCResponse tryPay(@RequestBody ClientBillTryPayTCCRequest request);

	// @RequestMapping(value = API_PREFIX + "/{billId}", method =
	// RequestMethod.PUT)
	// public void confirm(@PathVariable String billId);

}
