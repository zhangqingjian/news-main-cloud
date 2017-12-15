/**
 * 
 */
package com.yo.news.sale.orders.controller;

import java.time.OffsetDateTime;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.yo.news.sale.framework.controller.BaseController;
import com.yo.news.sale.framework.web.ServletContextHolder;
import com.yo.news.sale.orders.vo.OrderTCCPayParticipantVO;
import com.yo.news.sale.orders.controller.request.OrderTCCTryPayRequest;
import com.yo.news.sale.orders.controller.response.OrderTCCTryPayResponse;

import io.swagger.annotations.ApiOperation;

/**
*/
/**
 * @author JAN
 * @CreatedTime：2017年11月14日 上午10:08:03 说明：
 */
@RestController
@RequestMapping(value = OrderPayTccController.API_PREFIX)
public class OrderPayTccController extends BaseController
{
	protected final static String API_PREFIX = "/news/order/v1";
	@Value("{spring.application.name}")
	private String applicationName;

	private final String ORDER_TCC_PAY_URL = "/pay/tcc";

	@ApiOperation(value = "更新订单为支付状态", notes = "该接口用于支付的时候更新订单的支付状态")
	@RequestMapping(value = ORDER_TCC_PAY_URL, method = RequestMethod.POST)
	public OrderTCCTryPayResponse tryPay(@Valid @RequestBody OrderTCCTryPayRequest request, BindingResult result)
	{
		System.out.println("pay requestId is:" + ServletContextHolder.fetchRequestId());
		OrderTCCTryPayResponse response = new OrderTCCTryPayResponse();
		OrderTCCPayParticipantVO participantVO = new OrderTCCPayParticipantVO();
		// 五秒钟后过期
		participantVO.setExpiredTime(OffsetDateTime.now().plusSeconds(5));
		participantVO.setUrl("http://" + applicationName + API_PREFIX + ORDER_TCC_PAY_URL + "/" + request.getOrderId());
		response.setParticipantVO(participantVO);
		return response;
	}

	@ApiOperation(value = "确认更新", notes = "TCC是先尝试更新，此处为确认")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@RequestMapping(value = ORDER_TCC_PAY_URL + "/{orderId}", method = RequestMethod.PUT)
	public void confirm(@PathVariable String orderId, HttpSession session)
	{
		System.out.println(orderId + "确认更新订单状态为已支付");
	}

	@ApiOperation(value = "取消支付")
	@RequestMapping(value = ORDER_TCC_PAY_URL + "/{orderId}", method = RequestMethod.DELETE)
	public void cancel(@PathVariable String orderId, HttpSession session)
	{
		System.out.println(orderId + "取消订单为已支付的状态");
	}
}
