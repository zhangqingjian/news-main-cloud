/**
 * 
 */
package com.yo.news.sale.orders.controller.request;

import javax.validation.constraints.Min;

import com.yo.news.sale.framework.model.request.IRequest;

import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
*/
/**
 * @author JAN
 * @CreatedTime：2017年11月14日 上午10:16:30 说明：
 */
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode
public class OrderTCCTryPayRequest implements IRequest
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5943348902593067142L;
	@NonNull
	@Min(1)
	private String orderId;
}
