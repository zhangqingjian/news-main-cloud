package com.yo.news.sale.framework.excepiton;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.yo.news.sale.framework.enums.IStatusCode;
import com.yo.news.sale.framework.model.response.ErrorResponse;
import com.yo.news.sale.framework.web.ServletContextHolder;

import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 */
public final class Shift
{

	private Shift()
	{
	}

	/**
	 * 抛出具体的{@code RestStatus}异常
	 *
	 * @param status
	 *            自定义异常实体
	 * @param details
	 *            额外添加至details字段中的任意实体, 最终会被解析成JSON
	 */
	public static void fatal(IStatusCode statusCode, Object... details)
	{
		checkNotNull(statusCode);
		final ErrorResponse entity = new ErrorResponse(statusCode);
		// inject details
		if (details.length > 0)
		{
			Optional.of(details).ifPresent(entity::setDetails);
		}
		// put it into request, details entity by Rest Status's name
		String errorCode = String.valueOf(statusCode.code());
		bindStatusCodesInRequestScope(errorCode, entity);
		throw new RestStatusException(errorCode);
	}

	private static void bindStatusCodesInRequestScope(String key, ErrorResponse entity)
	{
		checkNotNull(entity);
		checkNotNull(key);
		final RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		if (requestAttributes != null)
		{
			ServletContextHolder.setArrtibute(key, entity);
		}
	}
}