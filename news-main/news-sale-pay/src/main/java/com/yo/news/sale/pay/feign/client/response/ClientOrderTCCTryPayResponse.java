/**
 * 
 */
package com.yo.news.sale.pay.feign.client.response;

import com.yo.news.sale.framework.model.response.IResponse;
import com.yo.news.sale.pay.feign.client.model.ClientOrderTCCPayParticipantVO;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
*/
/**
 * @author JAN
 * @CreatedTime：2017年11月15日 上午9:47:24 说明：
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ClientOrderTCCTryPayResponse implements IResponse
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5396036329741833673L;
	private ClientOrderTCCPayParticipantVO participantVO;
}
