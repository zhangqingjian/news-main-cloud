/**
 * 
 */
package com.yo.news.sale.orders.controller.response;

import com.yo.news.sale.framework.model.response.IResponse;
import com.yo.news.sale.orders.vo.OrderTCCPayParticipantVO;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
*/
/**
 * @author JAN
 * @CreatedTime：2017年11月14日 上午10:18:34 说明：
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class OrderTCCTryPayResponse implements IResponse
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8060723771568935553L;
	private OrderTCCPayParticipantVO participantVO;
}
