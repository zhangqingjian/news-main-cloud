/**
 * 
 */
package com.yo.news.sale.pay.feign.client.model;

import java.io.Serializable;
import java.time.OffsetDateTime;

import org.hibernate.validator.constraints.URL;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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
 * @CreatedTime：2017年11月15日 上午10:12:58 说明：
 */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
//@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientTCCParticipantVO implements Serializable
{
	private static final long serialVersionUID = -6943170476507993604L;
	@URL
	@ApiModelProperty(value = "TCC进行执行的远程接口Url地址", required = true, example = "http://localhost:8080/1")
	private String url;

	@ApiModelProperty(value = "过期时间, ISO标准", required = true, example = "2017-03-20T14:00:41+08:00")
	@JsonSerialize(using = OffsetDateTimeToIso8601Serializer.class)
	private OffsetDateTime expireTime;

}
