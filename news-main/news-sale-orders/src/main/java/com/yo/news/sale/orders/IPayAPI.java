/**
 * 
 */
package com.yo.news.sale.orders;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 */
/**
 * @author JAN
 * @CreatedTime：2017年9月21日 下午5:29:16 说明：
 */
@FeignClient("news-sale-pay")
public interface IPayAPI
{
	@RequestMapping("/pay")
	String pay();
}
