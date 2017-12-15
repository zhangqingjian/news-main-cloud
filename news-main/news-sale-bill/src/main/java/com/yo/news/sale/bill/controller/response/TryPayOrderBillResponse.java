/**
 * 
 */
package com.yo.news.sale.bill.controller.response;

import com.yo.news.sale.bill.vo.BillPayTCCParticipant;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
*/
/**
 * @author JAN
 * @CreatedTime：2017年11月10日 下午6:15:15 说明：
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class TryPayOrderBillResponse
{
	@ApiModelProperty(value = "账单被确认的信息")
	private BillPayTCCParticipant confirmParticipant;
}
