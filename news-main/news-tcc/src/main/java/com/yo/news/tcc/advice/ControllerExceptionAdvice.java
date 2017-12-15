package com.yo.news.tcc.advice;

import com.google.common.collect.ImmutableMap;
import com.yo.news.sale.framework.annotation.RequestLogging;
import com.yo.news.sale.framework.enums.IStatusCode;
import com.yo.news.sale.framework.enums.StatusCode;
import com.yo.news.sale.framework.excepiton.IllegalValidateException;
import com.yo.news.sale.framework.excepiton.RestStatusException;
import com.yo.news.sale.framework.model.response.ErrorResponse;
import com.yo.news.sale.framework.web.RequestAttributeConst;
import com.yo.news.tcc.exception.ConfirmAllExpiredException;
import com.yo.news.tcc.exception.ConfirmExpireException;
import com.yo.news.tcc.exception.PartialConfirmException;
import com.yo.news.tcc.model.TccErrorResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;

/**
 */
@ControllerAdvice
public class ControllerExceptionAdvice
{
	private static final Logger LOGGER = LoggerFactory.getLogger(ControllerExceptionAdvice.class);
	private static final ImmutableMap<Class<? extends Throwable>, IStatusCode> EXCEPTION_MAPPINGS;
	@Value("${spring.application.name}")
	private String applicationName;

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
		// 其他未被发现的异常
		builder.put(Exception.class, StatusCode.SERVER_UNKNOWN_ERROR);
		EXCEPTION_MAPPINGS = builder.build();
	}

	/**
	 * <strong>Request域取出对应错误信息</strong>, 封装成实体ErrorEntity后转换成JSON输出
	 *
	 * @param e
	 *            {@code StatusCode}异常
	 * @param request
	 *            HttpServletRequest
	 * @return ErrorEntity
	 * @see ErrorEntity
	 * @see StatusCode
	 */
	@ResponseBody
	@RequestLogging
	@ExceptionHandler(RestStatusException.class)
	public Object restStatusException(Exception e, HttpServletRequest request)
	{
		// 取出存储在Shift设定在Request Scope中的ErrorEntity
		return request.getAttribute(e.getMessage());
	}

	/**
	 * <strong>Request域取出对应错误信息</strong>, 封装成实体ErrorEntity后转换成JSON输出
	 *
	 * @param e
	 *            {@code IllegalValidateException}异常
	 * @param request
	 *            HttpServletRequest
	 * @return ErrorEntity
	 * @see ErrorEntity
	 */
	@ResponseBody
	@RequestLogging
	@ExceptionHandler(IllegalValidateException.class)
	public Object illegalValidateException(Exception e, HttpServletRequest request)
	{
		// 取出存储在Request域中的Map
		return request.getAttribute(e.getMessage());
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({ ConfirmExpireException.class, ConfirmAllExpiredException.class })
	public void expireReservationException(Exception e, HttpServletRequest request)
	{
	}

	@ResponseBody
	@RequestLogging
	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler(PartialConfirmException.class)
	public Object partialConfirmException(PartialConfirmException e, HttpServletRequest request)
	{
		final TccErrorResponse error = e.getErrorResponse();
		return new ErrorResponse(StatusCode.RESERVATION_CONFLICT, error);
	}

	@ResponseBody
	@RequestLogging
	@ExceptionHandler(Exception.class)
	public ErrorResponse exception(Exception e, HttpServletRequest request)
	{
		LOGGER.error("request id: {}\r\nexception: {}", request.getAttribute(RequestAttributeConst.REQUEST_ID), e);
		final IStatusCode status = EXCEPTION_MAPPINGS.get(e.getClass());
		ErrorResponse error;
		if (status != null)
		{
			error = new ErrorResponse(status);
		}
		else
		{
			// 未知异常
			error = new ErrorResponse(StatusCode.SERVER_UNKNOWN_ERROR, e.getMessage());
			// 检测是否服务还未完全启动
			if (e instanceof IllegalStateException)
			{
				if (e.getMessage().contains("No instances available for " + applicationName))
				{
					error = new ErrorResponse(StatusCode.SERVICE_INITIALIZING);
				}
			}
		}
		return error;
	}

}
