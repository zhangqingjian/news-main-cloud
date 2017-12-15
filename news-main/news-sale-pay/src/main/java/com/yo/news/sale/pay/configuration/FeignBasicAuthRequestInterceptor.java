/**
 * 
 */
package com.yo.news.sale.pay.configuration;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
*/
/**
 * @author JAN
 * @CreatedTime：2017年11月27日 下午5:05:25 说明：
 */
/*** Feign请求拦截器* @author yinjihuan* @create 2017-11-10 17:25 **/
public class FeignBasicAuthRequestInterceptor implements RequestInterceptor
{
	private String requestId;
	public FeignBasicAuthRequestInterceptor(String reuqestId)
	{
		this.requestId=requestId;
	}

	@Override
	public void apply(RequestTemplate template)
	{
		System.out.println(requestId);
//		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//		HttpServletRequest request = attributes.getRequest();
//		Enumeration<String> headerNames = request.getHeaderNames();
//		if (headerNames != null)
//		{
//			while (headerNames.hasMoreElements())
//			{
//				String name = headerNames.nextElement();
//				String values = request.getHeader(name);
//				template.header(name, values);
//			}
//		}
	}
}