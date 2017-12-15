/**
 * 
 */
package com.yo.news.sale.framework.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
*/
/**
 * @author JAN
 * @CreatedTime：2017年10月11日 上午10:40:58 说明：
 */
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestfulRequest implements IRequest
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6943039668556144852L;

}
