/**
 * 
 */
package com.yo.news.sale.pay.feign.client;

import org.springframework.stereotype.Component;

import com.yo.news.sale.pay.feign.client.request.ClientBillTryPayTCCRequest;
import com.yo.news.sale.pay.feign.client.response.ClientBillTryPayTCCResponse;

/**
*/
/**
 * @author JAN
 * @CreatedTime：2017年11月14日 下午5:44:03 说明：
 */
@Component
public class BillFeignClientFallBack implements BillFeignClient
{

	/**
	 * @author JAN
	 * @CreatedTime：2017年11月15日 上午9:37:10 说明：
	 * @param request
	 * @return
	 */
	public ClientBillTryPayTCCResponse tryPay(ClientBillTryPayTCCRequest request)
	{
		System.out.println("BillFeignClientFallBack tryPay收到接口无法正常访问");
		return null;
	}

	/**
	 * @author JAN
	 * @CreatedTime：2017年11月15日 上午9:42:37 说明：
	 * @param billId
	 */
	// @Override
	// public void confirm(String billId)
	// {
	// System.out.println("BillFeignClientFallBack confirm收到接口无法正常访问");
	//
	// }

}
