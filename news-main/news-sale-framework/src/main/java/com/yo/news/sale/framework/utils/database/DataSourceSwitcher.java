/**
 * 
 */
package com.yo.news.sale.framework.utils.database;

import org.springframework.util.Assert;

/**
 */
/**
 * @author JAN
 * @CreatedTime：2016年1月13日 下午1:47:28 说明：
 */
public class DataSourceSwitcher
{
	@SuppressWarnings("rawtypes")
	private static final ThreadLocal contextHolder = new ThreadLocal();

	@SuppressWarnings("unchecked")
	public static void setDataSource(String dataSource)
	{
		Assert.notNull(dataSource, "dataSource cannot be null");
		contextHolder.set(dataSource);
	}

	public static void setMaster()
	{
		clearDataSource();
//		setDataSource("master");
	}

	public static void setSlave()
	{
		setDataSource("slave");
	}

	public static String getDataSource()
	{
		System.out.println("is master or slave:"+(String) contextHolder.get());
		return (String) contextHolder.get();
	}

	public static void clearDataSource()
	{
		contextHolder.remove();
	}
}
