/**
 * 
 */
package com.yo.news.sale.pay.ebo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yo.base.utils.base.JsonUtil;
import com.yo.news.sale.framework.utils.Jacksons;
import com.yo.news.sale.framework.web.ServletContextHolder;
import com.yo.news.sale.pay.feign.client.BillFeignClient;
import com.yo.news.sale.pay.feign.client.OrderFeignClient;
import com.yo.news.sale.pay.feign.client.TCCFeignClient;
import com.yo.news.sale.pay.feign.client.model.ClientBillPayTCCParticipantVO;
import com.yo.news.sale.pay.feign.client.model.ClientOrderTCCPayParticipantVO;
import com.yo.news.sale.pay.feign.client.model.ClientTCCParticipantVO;
import com.yo.news.sale.pay.feign.client.request.ClientBillTryPayTCCRequest;
import com.yo.news.sale.pay.feign.client.request.ClientOrderTCCTryPayRequest;
import com.yo.news.sale.pay.feign.client.request.ClientTCCRequest;
import com.yo.news.sale.pay.feign.client.response.ClientBillTryPayTCCResponse;
import com.yo.news.sale.pay.feign.client.response.ClientOrderTCCTryPayResponse;

/**
*/
/**
 * @author JAN
 * @CreatedTime：2017年11月15日 上午9:59:57 说明：
 */
@Service
public class PayTCCEbo
{
	@Autowired
	TCCFeignClient tCCFeignClient;

	@Autowired
	BillFeignClient billFeignClient;

	@Autowired
	OrderFeignClient orderFeignClient;

	public void payTcc(String orderId)
	{
		String billId = "11";
		System.out.println("pay requestId is:" + ServletContextHolder.fetchRequestId());
		// tcc 订单
		ClientOrderTCCTryPayRequest clientOrderTCCTryPayRequest = new ClientOrderTCCTryPayRequest();
		clientOrderTCCTryPayRequest.setOrderId(orderId);
		ClientOrderTCCTryPayResponse clientOrderTCCTryPayResponse = orderFeignClient.tryPay(clientOrderTCCTryPayRequest);
		ClientOrderTCCPayParticipantVO clientOrderTCCPayParticipantVO = clientOrderTCCTryPayResponse.getParticipantVO();
		// tcc 账单
		ClientBillTryPayTCCRequest clientBillTryPayTCCRequest = new ClientBillTryPayTCCRequest();
		clientBillTryPayTCCRequest.setBillId("1231231");
		ClientBillTryPayTCCResponse clientBillTryPayTCCResponse = billFeignClient.tryPay(clientBillTryPayTCCRequest);
		ClientBillPayTCCParticipantVO clientBillPayTCCParticipantVO = clientBillTryPayTCCResponse.getConfirmParticipant();

		ClientTCCParticipantVO orderTCCParticipantVO = new ClientTCCParticipantVO();
		orderTCCParticipantVO.setUrl(clientOrderTCCTryPayResponse.getParticipantVO().getUrl());
		orderTCCParticipantVO.setExpireTime(clientOrderTCCTryPayResponse.getParticipantVO().getExpiredTime());

		ClientTCCParticipantVO billTCCParticipantVO = new ClientTCCParticipantVO();
		billTCCParticipantVO.setUrl(clientBillTryPayTCCResponse.getConfirmParticipant().getUrl());
		billTCCParticipantVO.setExpireTime(clientBillTryPayTCCResponse.getConfirmParticipant().getExpiredTime());

		List<ClientTCCParticipantVO> list = new ArrayList<ClientTCCParticipantVO>();
		list.add(orderTCCParticipantVO);
		list.add(billTCCParticipantVO);
		ClientTCCRequest clientTCCRequest = new ClientTCCRequest(list);
		System.out.println(Jacksons.parse(clientTCCRequest));
		tCCFeignClient.confirm(clientTCCRequest);
	}

}
