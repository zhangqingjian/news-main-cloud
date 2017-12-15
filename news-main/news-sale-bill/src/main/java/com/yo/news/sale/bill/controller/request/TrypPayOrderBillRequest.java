/**
 * 
 */
package com.yo.news.sale.bill.controller.request;

import javax.validation.constraints.Min;

import com.yo.news.sale.framework.model.request.IRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

/**
*/
/**
 * @author JAN
 * @CreatedTime：2017年11月14日 上午9:44:23 说明：
 */
@Getter
@Setter
@NoArgsConstructor
public class TrypPayOrderBillRequest implements IRequest
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2506763938351919869L;
	@NonNull
	@Min(1)
	@ApiModelProperty(value = "账单ID", required = true)
	private String billId;
}
