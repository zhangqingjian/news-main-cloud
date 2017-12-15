/**
 * 
 */
package com.yo.news.sale.framework.excepiton;

/**
*/
/**
 * @author JAN
 * @CreatedTime：2017年10月24日 下午2:03:35 说明：
 */
public class RestStatusException extends RuntimeException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5730163270869633108L;

	public RestStatusException(String message)
	{
		super(message);
	}

	public RestStatusException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public RestStatusException(Throwable cause)
	{
		super(cause);
	}

	protected RestStatusException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
