package com.yo.news.sale.framework.dao.service;

public interface CrudService<T>
{
	int deleteByPrimaryKey(String orderId);

	int insertSelective(T record);

	T selectByPrimaryKey(String orderId);

	int updateByPrimaryKeySelective(T record);


}
