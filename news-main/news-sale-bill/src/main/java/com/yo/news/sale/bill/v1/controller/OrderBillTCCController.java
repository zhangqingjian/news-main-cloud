/**
 * 
 */
package com.yo.news.sale.bill.v1.controller;

import java.io.Console;
import java.time.OffsetDateTime;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.yo.news.sale.bill.controller.request.TrypPayOrderBillRequest;
import com.yo.news.sale.bill.controller.response.CreateOrderBillResponse;
import com.yo.news.sale.bill.controller.response.TryPayOrderBillResponse;
import com.yo.news.sale.bill.vo.BillPayTCCParticipant;
import com.yo.news.sale.framework.controller.BaseController;
import com.yo.news.sale.framework.model.response.ObjectDataResponse;
import io.swagger.annotations.ApiOperation;

/**
*/
/**
 * @author JAN
 * @CreatedTime：2017年11月10日 下午4:13:21 说明：
 */
@RestController
@RequestMapping(value = OrderBillTCCController.API_PREFIX)
public class OrderBillTCCController extends BaseController
{
	protected final static String API_PREFIX = "/news/order/v1/bill";
	@Value("${spring.application.name}")
	private String applicationName;
	private final String CONFIRM_PAY_URL = "/pay/tcc";

	@ApiOperation(value = "将账单的状态改成已支付", notes = "将账单的状态改成已支付")
	@RequestMapping(value = CONFIRM_PAY_URL, method = RequestMethod.POST)
	public TryPayOrderBillResponse tryPay(@Valid @RequestBody TrypPayOrderBillRequest request, BindingResult result)
	{
		String url = "http://" + applicationName + API_PREFIX + CONFIRM_PAY_URL + "/" + request.getBillId();
		OffsetDateTime expiredTime = OffsetDateTime.now().plusSeconds(15);// 15秒之后将会过期
		BillPayTCCParticipant participant = new BillPayTCCParticipant(url, expiredTime);
		TryPayOrderBillResponse response = new TryPayOrderBillResponse(participant);
		response.setConfirmParticipant(participant);
		System.out.println(request.getBillId()+"账单预先被支付了");
		return response;
	}

	@ApiOperation(value = "确认提交")
	@RequestMapping(value = CONFIRM_PAY_URL + "/{billId}", method = RequestMethod.PUT)
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void confirm(@PathVariable String billId)
	{
		System.out.println(billId + "账单确认支付了");
	}

	@ApiOperation(value = "取消")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@RequestMapping(value = CONFIRM_PAY_URL + "{billId}", method = RequestMethod.DELETE)
	public void cancel(@PathVariable String billId)
	{
		System.out.println(billId + "账单取消支付了");
	}

}
