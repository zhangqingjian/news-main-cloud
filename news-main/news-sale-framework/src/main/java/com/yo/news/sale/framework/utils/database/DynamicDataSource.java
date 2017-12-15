/**
 * 
 */
package com.yo.news.sale.framework.utils.database;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 */
/**
 * @author  JAN   
 * @CreatedTime：2016年1月13日 下午1:46:50
 * 说明：
 */
public class DynamicDataSource extends AbstractRoutingDataSource 
{

	/**
	 * @author  JAN   
	 * @CreatedTime：2016年1月13日 下午1:47:04
	 * 说明：
	 * @return
	 */
	@Override
	protected Object determineCurrentLookupKey()
	{
		return DataSourceSwitcher.getDataSource();
	}
	public void test()
	{
		DynamicDataSource dataSource=new DynamicDataSource();
	
		 
	}

}
