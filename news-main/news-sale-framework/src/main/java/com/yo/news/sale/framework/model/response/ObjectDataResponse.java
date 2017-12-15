/**
 * 
 */
package com.yo.news.sale.framework.model.response;

import lombok.Getter;
import lombok.Setter;

/**
*/
/**
 * @author JAN
 * @CreatedTime：2017年10月11日 下午1:52:27 说明：
 */
@Setter
@Getter
public class ObjectDataResponse<T> extends RestfulResponse
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7984804916009383054L;
	private T data;

	public ObjectDataResponse(T data)
	{
		this.data = data;
	}
}
