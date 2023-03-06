package com.shaw.openai.api.moderation;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author shaw
 * @date 2023/2/28
 *
 * https://beta.openai.com/docs/api-reference/moderations/create
 */
@Data
public class ModerationCategoryScores {

	public double hate;

	@JsonProperty("hate/threatening")
	public double hateThreatening;

	@JsonProperty("self-harm")
	public double selfHarm;

	public double sexual;

	@JsonProperty("sexual/minors")
	public double sexualMinors;

	public double violence;

	@JsonProperty("violence/graphic")
	public double violenceGraphic;
}
