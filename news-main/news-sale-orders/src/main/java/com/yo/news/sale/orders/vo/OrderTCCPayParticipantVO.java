/**
 * 
 */
package com.yo.news.sale.orders.vo;

import java.io.Serializable;
import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.yo.news.sale.framework.utils.OffsetDateTimeToIso8601Serializer;

import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
*/
/**
 * @author JAN
 * @CreatedTime：2017年11月14日 上午10:20:19 说明：
 */
@Getter
@Setter
@lombok.ToString
@EqualsAndHashCode
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderTCCPayParticipantVO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7841495547856132827L;
	@ApiModelProperty(value = "执行TCC的Url地址")
	private String url;
	@JsonSerialize(using = OffsetDateTimeToIso8601Serializer.class)
	@ApiModelProperty(value = "过期时间", example = "", notes = "过期的时间点")
	private OffsetDateTime expiredTime;
}
