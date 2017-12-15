/**
 * 
 */
package com.yo.news.sale.pay.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.yo.news.sale.framework.domain.BasicDomain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
*/
/**
 * @author JAN
 * @CreatedTime：2017年10月11日 下午2:00:20 说明：
 */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PayOrderDo extends BasicDomain
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3747798970007344075L;
	private Long userId;
	private Integer price;
}
