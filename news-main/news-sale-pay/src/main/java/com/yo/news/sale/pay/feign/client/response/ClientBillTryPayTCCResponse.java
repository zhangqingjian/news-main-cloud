/**
 * 
 */
package com.yo.news.sale.pay.feign.client.response;

import com.yo.news.sale.framework.model.response.IResponse;
import com.yo.news.sale.pay.feign.client.model.ClientBillPayTCCParticipantVO;

import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
*/
/**
 * @author JAN
 * @CreatedTime：2017年11月15日 上午9:30:52 说明：
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class ClientBillTryPayTCCResponse implements IResponse
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4786745804048279101L;
	@ApiModelProperty(value = "TCC事务参与信息")
	private ClientBillPayTCCParticipantVO confirmParticipant;
}
