/**
 * 
 */
package com.yo.news.sale.framework.enums;

/**
*/
/**
 * @author JAN
 * @CreatedTime：2017年10月12日 下午3:20:01 说明：
 */
public interface IStatusCode
{
	/**
	 * the status codes of per restful request.
	 *
	 * @return 20xxx if succeed, 40xxx if client error, 50xxx if server side
	 *         crash.
	 */
	int code();

	/**
	 * @return status enum name
	 */
	String name();

	/**
	 * @return message summary
	 */
	String message();
}
