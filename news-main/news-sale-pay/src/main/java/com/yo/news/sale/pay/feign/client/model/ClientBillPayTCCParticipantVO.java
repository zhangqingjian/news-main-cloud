/**
 * 
 */
package com.yo.news.sale.pay.feign.client.model;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.yo.news.sale.framework.utils.OffsetDateTimeToIso8601Deserializer;
import com.yo.news.sale.framework.utils.OffsetDateTimeToIso8601Serializer;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
*/
/**
 * @author JAN
 * @CreatedTime：2017年11月15日 上午9:29:35 说明：
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class ClientBillPayTCCParticipantVO
{
	@ApiModelProperty(value = "进行tcc请求时的url地址")
	private String url;
	@ApiModelProperty(value = "过期时间", example = "")
	@JsonSerialize(using = OffsetDateTimeToIso8601Serializer.class)
	@JsonDeserialize(using = OffsetDateTimeToIso8601Deserializer.class)
	private OffsetDateTime expiredTime;
}
