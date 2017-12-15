/**
 * 
 */
package com.yo.news.ttc.controller.request;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.yo.news.sale.framework.model.request.RestfulRequest;
import com.yo.news.tcc.domain.TCCParticipant;

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
 * @CreatedTime：2017年10月23日 下午1:57:53 说明：
 */
@Getter
@Setter
@JsonInclude(value = Include.NON_NULL)
// @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class TccRequest extends RestfulRequest
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3967931849561370807L;
	@Size(min = 1)
	@Valid
	@NotNull
	@ApiModelProperty(required = true, value = "TCC 需要的参与方信息集合", notes = "TCC 需要的参与方信息集合")
	private List<TCCParticipant> participants;
}
