/**
 * 
 */
package com.yo.news.sale.framework.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.base.Preconditions;
import com.yo.news.sale.framework.enums.IStatusCode;
import com.yo.news.sale.framework.utils.Jacksons;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
*/
/**
 * @author JAN
 * @CreatedTime：2017年10月12日 下午2:54:56 说明：
 */
@Getter
@Setter
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ErrorResponse
{
	private int code = -1;
	private String msg;
	private Object details;
	public ErrorResponse(IStatusCode statusCodes)
	{
		Preconditions.checkNotNull(statusCodes);
		this.code = statusCodes.code();
	}

	public ErrorResponse(IStatusCode statusCodes, Object details)
	{
		Preconditions.checkNotNull(statusCodes);
		this.code = statusCodes.code();
		this.msg = statusCodes.message();
		if (details != null)
		{
			this.details = details;
		}
	}

	@Override
	public String toString()
	{
		return "{\"code\":\"" + code + "\"," + "\"msg\":\"" + msg + "\"," + "\"details\":\"" + Jacksons.parse(details) + "\"" + "}";
	}
}
