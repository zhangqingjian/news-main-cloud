/**
 * 
 */
package com.yo.news.tcc.domain;

import java.io.Serializable;
import java.time.OffsetDateTime;

import org.hibernate.validator.constraints.URL;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.yo.news.sale.framework.utils.OffsetDateTimeToIso8601Deserializer;
import com.yo.news.sale.framework.utils.OffsetDateTimeToIso8601Serializer;
import com.yo.news.tcc.enums.TccStatus;

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
 * @CreatedTime：2017年10月23日 上午11:13:58 说明：
 */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
//@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TCCParticipant implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2777094476908969982L;
	@URL
	@ApiModelProperty(value = "TCC进行执行的远程接口Url地址", required = true, example = "http://localhost:8080/1")
	private String url;
	
	@ApiModelProperty(value = "过期时间, ISO标准", required = true, example = "2017-03-20T14:00:41+08:00")
	@JsonDeserialize(using=OffsetDateTimeToIso8601Deserializer.class)
	@JsonSerialize(using = OffsetDateTimeToIso8601Serializer.class)
	private OffsetDateTime expireTime;
	@ApiModelProperty(notes = "执行时间", required = true, hidden = true, example = "2017-03-20T14:00:41+08:00")
	@JsonSerialize(using = OffsetDateTimeToIso8601Serializer.class)
	@JsonDeserialize(using=OffsetDateTimeToIso8601Deserializer.class)
	private OffsetDateTime executeTime;

	@ApiModelProperty(notes = "TCC执行出错的错误信息", hidden = true, required = true)
	private ResponseEntity<?> errorResponse;

	@ApiModelProperty(notes = "执行过程中，TCC处于什么状态", hidden = true, required = true)
	private TccStatus tccStatus = TccStatus.BEING_CONFIRMED;
}
