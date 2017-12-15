/**
 * 
 */
package com.yo.news.sale.pay.controller.request;

import java.math.BigInteger;

import javax.validation.constraints.Size;

import com.yo.news.sale.framework.model.request.RestfulRequest;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
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
 * @CreatedTime：2017年10月10日 下午1:30:19 说明：
 */
@NoArgsConstructor
@Setter
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class PayRequest extends RestfulRequest
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8108889982142324799L;
	@NonNull
	@ApiModelProperty(value = "订单Id", required = true, example = "112312312")
	private Integer orderId;
	@Size(min = 5)
	@ApiModelProperty(value = "测试")
	private String str;
	@Size(min = 5)
	@ApiModelProperty(value = "测试")
	private String str2;
}
