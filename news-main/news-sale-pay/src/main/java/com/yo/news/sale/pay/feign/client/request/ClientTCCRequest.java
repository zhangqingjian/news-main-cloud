/**
 * 
 */
package com.yo.news.sale.pay.feign.client.request;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.yo.news.sale.pay.feign.client.model.ClientTCCParticipantVO;

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
 * @CreatedTime：2017年11月15日 上午10:12:28 说明：
 */
@Getter
@Setter
@JsonInclude(value = Include.NON_NULL)
// @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ClientTCCRequest
{
	private static final long serialVersionUID = -3967931849561370807L;
	@Size(min = 1)
	@Valid
	@NotNull
	@ApiModelProperty(required = true, value = "TCC 需要的参与方信息集合", notes = "TCC 需要的参与方信息集合")
	private List<ClientTCCParticipantVO> participants;
}
