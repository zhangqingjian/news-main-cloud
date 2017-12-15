package com.yo.news.sale.pay.mapper;

import com.yo.news.sale.framework.annotation.MyBatisRepository;
import com.yo.news.sale.framework.dao.service.CrudMapper;
import com.yo.news.sale.pay.domain.OrderPO;

@MyBatisRepository
public interface OrderPOMapper extends CrudMapper<OrderPO>
{
	int deleteByPrimaryKey(String orderId);

	int insert(OrderPO record);

	int insertSelective(OrderPO record);

	OrderPO selectByPrimaryKey(String orderId);

	int updateByPrimaryKeySelective(OrderPO record);

	int updateByPrimaryKey(OrderPO record);
}