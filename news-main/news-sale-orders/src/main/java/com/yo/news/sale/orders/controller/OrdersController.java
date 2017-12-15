/**
 * 
 */
package com.yo.news.sale.orders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yo.news.sale.framework.annotation.RequestLogging;
import com.yo.news.sale.framework.controller.BaseController;
import com.yo.news.sale.orders.IPayAPI;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

/**
 */
/**
 * @author JAN
 * @CreatedTime：2017年9月21日 下午1:35:25 说明：
 */
@RestController
@RequestMapping("/orders")
public class OrdersController extends BaseController
{

	@Value("${current}")
	String current;
	@Autowired
	IPayAPI iPayAPI;
	
	
	@ApiOperation(value = "支付接口接收的参数", notes = "用于第三方支付") // 使用该注解描述接口方法信息
	@ApiModelProperty(value = "主键", hidden = false, notes = "主键，隐藏", required = true, dataType = "Long") // 使用该注解描述属性信息,当hidden=true时，该属性不会在api中显示
	@RequestMapping(value = { "/pay" }, method = RequestMethod.GET)
	public String pay()
	{
		
		return iPayAPI.pay();
	}

	@GetMapping("/config")
	public String config()
	{
		return current;
	}
}
