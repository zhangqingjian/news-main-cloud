/**
 * 
 */
package com.yo.news.sale.orders.domain;

import java.io.Serializable;

import org.hibernate.validator.constraints.URL;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.yo.news.sale.framework.utils.OffsetDateTimeToIso8601Serializer;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
*/
/**
 * @author JAN
 * @CreatedTime：2017年10月26日 上午9:38:05 说明：
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class OrderParticipant implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1370853984927820207L;

	@URL
	@ApiModelProperty(value = "订单确认的url地址", required = true, example = "http://localhost:8080/1")
	private String url;
	@JsonSerialize(using = OffsetDateTimeToIso8601Serializer.class)
	@ApiModelProperty(value = "过期时间，IOS标准", required = true, example = "2017-03-20T14:00:41+08:00")
	private String expiredTime;
}
