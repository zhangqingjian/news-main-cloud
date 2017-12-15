package com.yo.news.sale.framework.dao.service;

/**
 * MyBatis通用Mapper, 通常搭配MBG一起使用
 *
 */
public interface CrudMapper<T>
{

	int deleteByPrimaryKey(String orderId);

	int insertSelective(T record);

	T selectByPrimaryKey(String orderId);

	int updateByPrimaryKeySelective(T record);

}
