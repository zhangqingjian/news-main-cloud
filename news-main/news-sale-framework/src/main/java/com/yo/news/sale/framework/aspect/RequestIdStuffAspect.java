/**
 * 
 */
package com.yo.news.sale.framework.aspect;

import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;

import com.yo.news.sale.framework.web.RequestAttributeConst;
import com.yo.news.sale.framework.web.ServletContextHolder;

/**
*/
/**
 * @author JAN
 * @CreatedTime：2017年10月11日 下午5:49:07 说明：
 */
@Aspect
public class RequestIdStuffAspect implements Ordered
{

	private static final Logger logApi = LoggerFactory.getLogger(RequestIdStuffAspect.class);

	private int order = 0;

	public RequestIdStuffAspect(int order)
	{
		this.order = order;
	}

	@Before(value = "within(com.yo.news..*)&&(@annotation(org.springframework.web.bind.annotation.RequestMapping))")
	public void before(JoinPoint joinpoint)
	{
		final String requestId = ServletContextHolder.fetchRequestId();
		final HttpServletResponse response = ServletContextHolder.getResponse();
		if (response.getHeader(RequestAttributeConst.REQUEST_ID) == null)
		{
			response.addHeader(RequestAttributeConst.REQUEST_ID, requestId);
		}
	}

	@After(value = "within(com.yo.news..*)&&(@annotation(org.springframework.web.bind.annotation.ResponseBody))")
	public void after(JoinPoint joinPoint)
	{
		System.out.println("advice after");
	}

	/**
	 * @author JAN
	 * @CreatedTime：2017年10月11日 下午5:49:37 说明：
	 * @return
	 */
	@Override
	public int getOrder()
	{
		// TODO 自动生成的方法存根
		return order;
	}

}
