/**
 * 
 */
package com.yo.news.sale.bill.vo;

import lombok.Setter;
import lombok.ToString;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.yo.news.sale.framework.utils.OffsetDateTimeToIso8601Serializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
*/
/**
 * @author JAN
 * @CreatedTime：2017年11月10日 下午6:17:28 说明：
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class BillPayTCCParticipant
{

	@ApiModelProperty(value = "进行tcc请求时的url地址")
	private String url;
	@ApiModelProperty(value = "过期时间", example = "")
	@JsonSerialize(using = OffsetDateTimeToIso8601Serializer.class)
	private OffsetDateTime expiredTime;

}
