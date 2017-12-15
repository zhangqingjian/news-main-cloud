/**
 * 
 */
package com.yo.news.sale.framework.excepiton;

/**
*/
/**
 * @author JAN
 * @CreatedTime：2017年10月12日 下午3:44:51 说明：
 */
public class IllegalValidateException extends RuntimeException
{

	/**
	 * @param errorCode
	 */
	public IllegalValidateException(String message)
	{
		super(message);
	}

	public IllegalValidateException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public IllegalValidateException(Throwable cause)
	{
		super(cause);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -7132014468896723223L;

}
