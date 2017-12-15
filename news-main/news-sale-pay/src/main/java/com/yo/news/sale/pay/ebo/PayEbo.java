/**
 * 
 */
package com.yo.news.sale.pay.ebo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yo.base.utils.base.MyDateTime;
import com.yo.news.sale.framework.dao.service.CrudMapper;
import com.yo.news.sale.framework.dao.service.CrudServiceImpl;
import com.yo.news.sale.pay.domain.OrderPO;
import com.yo.news.sale.pay.mapper.OrderPOMapper;

/**
*/
/**
 * @author JAN
 * @CreatedTime：2017年10月17日 上午11:07:13 说明：
 */
@Service
public class PayEbo extends CrudServiceImpl<OrderPO>
{
	/**
	 * @param mapper
	 */
	@Autowired
	public PayEbo(CrudMapper<OrderPO> mapper)
	{
		super(mapper);
		// TODO 自动生成的构造函数存根
	}

	@Autowired
	OrderPOMapper orderPOMapper;

	@Transactional
	public OrderPO update(String orderId)
	{
		OrderPO orderPO = new OrderPO();
		orderPO.setOrderId(orderId);
		orderPO.setCreatedTime(MyDateTime.getTime10());
		orderPOMapper.updateByPrimaryKeySelective(orderPO);
		throw new RuntimeException("mad");
		// return orderPOMapper.selectByPrimaryKey(orderId);
	}

	// public OrderPO selectByPrimaryKey(String orderId)
	// {
	// OrderPO orderPO = new OrderPO();
	// orderPO.setOrderId(orderId);
	// orderPO.setCreatedTime(MyDateTime.getTime10());
	//
	// return orderPOMapper.selectByPrimaryKey(orderId);
	// }

}
