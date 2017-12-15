package com.yo.news.tcc.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.yo.news.tcc.domain.TCCParticipant;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TccErrorResponse implements Serializable
{

	private static final long serialVersionUID = 6016973979617189095L;

	@Valid
	@NotNull
	@Size(min = 1)
	@ApiModelProperty(value = "参与方提供的链接集合", required = true)
	private List<TCCParticipant> tccParticipants;

}
