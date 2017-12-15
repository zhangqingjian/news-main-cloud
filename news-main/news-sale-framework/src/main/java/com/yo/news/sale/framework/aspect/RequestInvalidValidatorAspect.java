/**
 * 
 */
package com.yo.news.sale.framework.aspect;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import com.google.common.collect.Maps;
import com.yo.news.sale.framework.enums.IStatusCode;
import com.yo.news.sale.framework.enums.StatusCode;
import com.yo.news.sale.framework.excepiton.IllegalValidateException;
import com.yo.news.sale.framework.model.response.ErrorResponse;
import com.yo.news.sale.framework.web.ServletContextHolder;

/**
*/
/**
 * @author JAN
 * @CreatedTime：2017年10月12日 下午1:58:02 说明：
 */
@Aspect
public class RequestInvalidValidatorAspect implements Ordered
{
	private final static Logger LOGGER = LoggerFactory.getLogger(RequestInvalidValidatorAspect.class);
	private int order;
	private IStatusCode restStatus;

	public RequestInvalidValidatorAspect()
	{
		this(Byte.MAX_VALUE);
	}

	public RequestInvalidValidatorAspect(int order)
	{
		this.order = order;
	}

	public RequestInvalidValidatorAspect(int order, IStatusCode iRestStatus)
	{
		this.order = order;
		this.restStatus = iRestStatus;
	}

	// @Around(value =
	// "within(com.yo.news..*)&&(@annotation(org.springframework.web.bind.annotation.RequestMapping)||@annotation(org.springframework.web.bind.annotation.ResponseBody))")
	@Around(value = "within(com.yo.news..*)&&(@annotation(org.springframework.web.bind.annotation.RequestMapping))")
	public Object aroundMethod(ProceedingJoinPoint processJoinPoint) throws Throwable
	{
		for (Object obj : processJoinPoint.getArgs())
		{
			if (obj instanceof BindingResult)
			{
				BindingResult result = (BindingResult) obj;
				if (result.getErrorCount() > 0)
				{
					final HashMap<Object, Object> errorMap = Maps.newHashMap();
					for (FieldError fieldError : result.getFieldErrors())
					{
						errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
					}
					ErrorResponse errorResponse = new ErrorResponse(restStatus, errorMap);
					String errorCode = String.valueOf(restStatus.code());
					ServletContextHolder.setArrtibute(errorCode, errorResponse);
					throw new IllegalValidateException(errorCode);
				}
				break;
			}
		}

		return processJoinPoint.proceed();
	}

	/**
	 * @author JAN
	 * @CreatedTime：2017年10月12日 下午1:58:31 说明：
	 * @return
	 */
	@Override
	public int getOrder()
	{
		// TODO 自动生成的方法存根
		return order;
	}

}
