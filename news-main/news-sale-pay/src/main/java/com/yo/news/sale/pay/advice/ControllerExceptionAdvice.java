/**
 * 
 */
package com.yo.news.sale.pay.advice;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.google.common.collect.ImmutableMap;
import com.yo.news.sale.framework.annotation.RequestLogging;
import com.yo.news.sale.framework.enums.IStatusCode;
import com.yo.news.sale.framework.enums.StatusCode;
import com.yo.news.sale.framework.excepiton.IllegalValidateException;
import com.yo.news.sale.framework.excepiton.RestStatusException;
import com.yo.news.sale.framework.model.response.ErrorResponse;
import com.yo.news.sale.framework.web.RequestAttributeConst;
import com.yo.news.sale.framework.web.ServletContextHolder;

/**
*/
/**
 * @author JAN
 * @CreatedTime：2017年10月11日 上午9:27:14 说明：
 */
@ControllerAdvice
public class ControllerExceptionAdvice
{
	private static final ImmutableMap<Class<? extends Throwable>, IStatusCode> EXCEPTION_MAPPINGS;
	final static Logger LOGGER = LoggerFactory.getLogger(ControllerExceptionAdvice.class);
	static
	{
		final ImmutableMap.Builder<Class<? extends Throwable>, IStatusCode> builder = ImmutableMap.builder();
		// SpringMVC中参数类型转换异常，常见于String找不到对应的ENUM而抛出的异常
		builder.put(MethodArgumentTypeMismatchException.class, StatusCode.INVALID_PARAMS_CONVERSION);
		builder.put(UnsatisfiedServletRequestParameterException.class, StatusCode.INVALID_PARAMS_CONVERSION);
		// HTTP Request Method不存在
		builder.put(HttpRequestMethodNotSupportedException.class, StatusCode.REQUEST_METHOD_NOT_SUPPORTED);
		// 要求有RequestBody的地方却传入了NULL
		builder.put(HttpMessageNotReadableException.class, StatusCode.HTTP_MESSAGE_NOT_READABLE);
		// 通常是操作过快导致DuplicateKey
		builder.put(DuplicateKeyException.class, StatusCode.DUPLICATE_KEY);
		// 其他未被发现的异常
		builder.put(Exception.class, StatusCode.SERVER_UNKNOWN_ERROR);
		EXCEPTION_MAPPINGS = builder.build();
	}

	@ExceptionHandler(value = IllegalValidateException.class)
	@ResponseBody
	@RequestMapping
	public Object illegalInvalidateException(Exception e, HttpServletRequest request)
	{
		return ServletContextHolder.getAttribute(e.getMessage());
	}

	@ResponseBody
	@RequestLogging
	@ExceptionHandler(value = Exception.class)
	public ErrorResponse exception(Exception ex, HttpServletRequest request)
	{
		LOGGER.error("requestId:{}\r\nexception:{}", ServletContextHolder.getAttribute(RequestAttributeConst.REQUEST_ID), ex);
		final IStatusCode status = EXCEPTION_MAPPINGS.get(ex.getClass());
		final ErrorResponse error;
		if (status != null)
		{
			error = new ErrorResponse(status);
		}
		else
		{
			error = new ErrorResponse(StatusCode.SERVER_UNKNOWN_ERROR);
		}
		return error;
	}

	@ResponseBody
	@RequestLogging
	@ExceptionHandler(RestStatusException.class)
	public Object restStatusException(Exception e, HttpServletRequest request)
	{
		// 取出存储在Shift设定在Request Scope中的ErrorEntity
		return request.getAttribute(e.getMessage());
	}
	 
}
