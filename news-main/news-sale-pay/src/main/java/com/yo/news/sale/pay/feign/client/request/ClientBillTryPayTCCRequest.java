/**
 * 
 */
package com.yo.news.sale.pay.feign.client.request;

import com.yo.news.sale.framework.model.request.IRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;

import lombok.Setter;
import lombok.ToString;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
*/
/**
 * @author JAN
 * @CreatedTime：2017年11月15日 上午9:33:29 说明：
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class ClientBillTryPayTCCRequest implements IRequest
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3133515545271089275L;
	@ApiModelProperty(value = "账单ID")
	private String billId;
}
