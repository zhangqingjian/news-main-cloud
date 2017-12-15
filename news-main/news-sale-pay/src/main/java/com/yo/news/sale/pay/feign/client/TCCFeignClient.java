/**
 * 
 */
package com.yo.news.sale.pay.feign.client;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.yo.news.sale.pay.feign.client.request.ClientTCCRequest;

import io.swagger.annotations.ApiOperation;

/**
*/
/**
 * @author JAN
 * @CreatedTime：2017年11月15日 上午10:08:44 说明：
 */
@FeignClient(name = TCCFeignClient.SERVICE_ID)
// @FeignClient(name =
// TCCFeignClient.SERVICE_ID,fallback=TCCFeignClientFallback.class)
public interface TCCFeignClient
{
	public static final String SERVICE_ID = "news-tcc";
	static final String API_PREFIX = "/tcc/v1";

	@ApiOperation(value = "确认", notes = "确认", httpMethod = "PUT")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@RequestMapping(method = RequestMethod.PUT, path = API_PREFIX + "/confirm")
	public void confirm(@RequestBody ClientTCCRequest tccRequest);

	@ApiOperation(value = "取消", notes = "取消")
	@RequestMapping(method = RequestMethod.POST, path = API_PREFIX + "/cancel")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void cancel(@RequestBody ClientTCCRequest tccRequest);

}
