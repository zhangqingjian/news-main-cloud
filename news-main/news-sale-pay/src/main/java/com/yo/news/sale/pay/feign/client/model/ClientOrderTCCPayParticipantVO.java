/**
 * 
 */
package com.yo.news.sale.pay.feign.client.model;

import java.io.Serializable;
import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.yo.news.sale.framework.utils.OffsetDateTimeToIso8601Deserializer;
import com.yo.news.sale.framework.utils.OffsetDateTimeToIso8601Serializer;

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
 * @CreatedTime：2017年11月15日 上午9:47:42 说明：
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientOrderTCCPayParticipantVO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7841495547856132827L;
	@ApiModelProperty(value = "执行TCC的Url地址")
	private String url;
	@JsonSerialize(using = OffsetDateTimeToIso8601Serializer.class)
	@JsonDeserialize(using = OffsetDateTimeToIso8601Deserializer.class)
	@ApiModelProperty(value = "过期时间", example = "", notes = "过期的时间点")
	private OffsetDateTime expiredTime;
}
