/**
 * 
 */
package com.yo.news.sale.pay.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yo.news.sale.framework.redis.BaseCacheAgent;
import com.yo.news.sale.pay.domain.OrderPO;

/**
*/
/**
 * @author JAN
 * @CreatedTime：2017年10月18日 下午5:09:36 说明：
 */
@Repository
public class TestCache extends BaseCacheAgent<OrderPO>
{

	/**
	 * @author JAN
	 * @CreatedTime：2017年10月18日 下午5:10:02 说明：
	 * @param modelId
	 * @return
	 */
	@Override
	public String getCacheKey(String key)
	{
		// TODO 自动生成的方法存根
		return "test" + key;
	}

	/**
	 * @author JAN
	 * @CreatedTime：2017年10月18日 下午5:10:02 说明：
	 * @param modelId
	 * @return
	 * @throws Exception
	 */
	@Override
	public OrderPO getModel(String key) throws Exception
	{
		// TODO 自动生成的方法存根
		// return getEntity(getCacheKey(key));
		String cacheKey = getCacheKey(key);
		List<String> list = jedisCluster.hmget(cacheKey, "orderId", "buyerId");
		OrderPO orderPO = new OrderPO();
		orderPO.setOrderId(list.get(0));
		orderPO.setBuyerId(list.get(1));
		return orderPO;
	}

	/**
	 * @author JAN
	 * @CreatedTime：2017年10月18日 下午5:10:02 说明：
	 * @param t
	 * @return
	 * @throws Exception
	 */
	@Override
	public void setModel(OrderPO t) throws Exception
	{
		Map<String, String> map = new HashMap<>();
		putMap(map, "orderId", t.getOrderId() + "");
		putMap(map, "buyerId", t.getBuyerId() + "");
		String key = getCacheKey(t.getOrderId());
		String result = jedisCluster.hmset(key, map);

	}

}
