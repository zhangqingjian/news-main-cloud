/**
 * 
 */
package com.yo.news.sale.framerwork.web.filter;

import java.io.Console;
import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

/**
*/
/**
 * @author JAN
 * @CreatedTime：2017年10月11日 上午9:48:24 说明：
 */
public class FilterToRecordRequestInfoToContextFilter extends OncePerRequestFilter
{

	/**
	 * @author JAN
	 * @CreatedTime：2017年10月11日 上午9:59:46 说明：
	 * @param request
	 * @param response
	 * @param filterChain
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException
	{
		System.out.println("once filter");
		super.doFilter(request, response, filterChain);

	}

}
