/**
 * 
 */
package com.yo.news.sale.framework.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

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
 * @CreatedTime：2017年10月11日 下午1:43:34 说明：
 */
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class RestfulResponse implements IResponse
{
	private static final long serialVersionUID = -4784826875547387260L;
	/**
	 * 
	 */
	public static final int CODE_SUCCESS = 0;
	/**
	 * 
	 */
	@JsonProperty("code")
	@ApiModelProperty(value = "状态码", required = true)
	private int code = CODE_SUCCESS;
}
