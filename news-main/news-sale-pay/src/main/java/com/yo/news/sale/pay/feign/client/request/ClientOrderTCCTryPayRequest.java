/**
 * 
 */
package com.yo.news.sale.pay.feign.client.request;

import java.io.Serializable;

import javax.validation.constraints.Min;

import com.yo.news.sale.framework.model.request.IRequest;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

/**
*/
/**
 * @author JAN
 * @CreatedTime：2017年11月15日 上午9:55:41 说明：
 */

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class ClientOrderTCCTryPayRequest implements IRequest
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 498940052715343332L;
	/**
	 * 
	 */
	@NonNull
	@Min(1)
	private String orderId;
}
