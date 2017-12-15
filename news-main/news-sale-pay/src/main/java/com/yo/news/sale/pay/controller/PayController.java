/**
 * 
 */
package com.yo.news.sale.pay.controller;

import java.time.OffsetDateTime;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.converters.Auto;
import com.yo.base.utils.base.MyDateTime;
import com.yo.news.sale.framework.annotation.RequestLogging;
import com.yo.news.sale.framework.model.response.ObjectDataResponse;
import com.yo.news.sale.framework.redis.RedisTemplateBean;
import com.yo.news.sale.framework.utils.Jacksons;
import com.yo.news.sale.pay.cache.TestCache;
import com.yo.news.sale.pay.controller.request.PayRequest;
import com.yo.news.sale.pay.domain.OrderPO;
import com.yo.news.sale.pay.domain.PayOrderDo;
import com.yo.news.sale.pay.ebo.PayEbo;
import com.yo.news.sale.pay.ebo.PayTCCEbo;
import com.yo.news.sale.pay.feign.client.BillFeignClient;
import com.yo.news.sale.pay.feign.client.OrderFeignClient;
import com.yo.news.sale.pay.feign.client.TCCFeignClient;

import io.swagger.annotations.ApiOperation;
import redis.clients.jedis.JedisCluster;

/**
 * @author JAN
 * @CreatedTime：2017年9月20日 下午4:54:52 说明：
 */
@RestController
public class PayController
{
	private final static Logger logger = LoggerFactory.getLogger(PayController.class);
	@Autowired
	PayEbo payEbo;
	@Autowired
	RedisTemplateBean redisTemplateTest;
	@Autowired
	TestCache testCache;
	@Autowired
	PayTCCEbo payTCCEbo;

	/**
	 * @author JAN
	 * @CreatedTime：2017年11月14日 上午10:49:21 说明：
	 */
	@ApiOperation(value = "payTcc", notes = "payTcc")
	@RequestMapping(value = "/pay/do/{orderId}", method = RequestMethod.POST)
	public void payTcc(@PathVariable String orderId)
	{
		payTCCEbo.payTcc(orderId);
	}

	@ApiOperation(value = "确认提交")
	@RequestLogging
	@RequestMapping(value = "/pay", method = RequestMethod.PUT)

	public ObjectDataResponse<PayOrderDo> pay(@Valid @RequestBody PayRequest payRequest, BindingResult result, HttpSession session)
	{
		if (result.hasErrors())
		{
			System.out.println(Jacksons.parse(result));
		}

		logger.info("errr");
		try
		{

		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
		String id = session.getId();
		System.out.println("session id is " + id);
		PayOrderDo payOrderDo = new PayOrderDo();
		payOrderDo.setId(12312312L);
		payOrderDo.setCreateTime(OffsetDateTime.now());
		payOrderDo.setPrice(1000);
		return new ObjectDataResponse<PayOrderDo>(payOrderDo);
	}

	@ApiOperation(value = "确认2提交")
	@RequestMapping(value = "/pay2", method = RequestMethod.GET)
	public ObjectDataResponse<Object> pay2(@RequestParam("list") String[] list, HttpSession session)
	{
		return new ObjectDataResponse(list);
		// throw new HttpMessageNotReadableException("fsdf");
	}

	@RequestLogging
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ObjectDataResponse<OrderPO> getOrderById(@PathVariable String id, HttpSession session)
	{
		// redisTemplateTest.test();

		OrderPO obj = payEbo.selectByPrimaryKey(id);
		obj.setBuyerId(String.valueOf(session.getAttribute("redis")));
		try
		{
			testCache.setModel(obj);
		}
		catch (Exception e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		try
		{
			OrderPO orderPO = testCache.getModel(id);
			return new ObjectDataResponse<OrderPO>(orderPO);
		}
		catch (Exception e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return new ObjectDataResponse<OrderPO>(obj);
	}

	@RequestLogging
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ObjectDataResponse<OrderPO> updateOrderById(@PathVariable String id, HttpSession session)
	{
		session.setAttribute("redis", MyDateTime.getTime10());
		payEbo.update(id);
		return new ObjectDataResponse<OrderPO>(new OrderPO());
	}
}
