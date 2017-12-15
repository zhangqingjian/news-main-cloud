/**
 * 
 */
package com.yo.news.sale.framework.web;

import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.coyote.http11.filters.VoidInputFilter;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.common.base.Preconditions;

/**
*/
/**
 * @author JAN
 * @CreatedTime：2017年10月11日 下午6:06:05 说明：
 */
public class ServletContextHolder
{
	public static HttpServletRequest getRequest()
	{
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

	public static HttpServletResponse getResponse()
	{
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
	}

	public static String fetchRequestId()
	{
		String requestId = (String) getRequest().getAttribute(RequestAttributeConst.REQUEST_ID);
		if (requestId == null)
		{
			requestId = Optional.ofNullable(getRequest().getHeader(RequestAttributeConst.REQUEST_ID)).orElse("x-" + UUID.randomUUID());
			getRequest().setAttribute(RequestAttributeConst.REQUEST_ID, requestId);
		}
		return requestId;
	}

	public static void setArrtibute(String key, Object value)
	{
		getRequest().setAttribute(key, value);
	}

	public static Object getAttribute(String key)
	{
		return getRequest().getAttribute(key);
	}
}
