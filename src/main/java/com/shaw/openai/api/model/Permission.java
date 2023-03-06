package com.shaw.openai.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author shaw
 * @date 2023/2/28
 *
 *  https://platform.openai.com/docs/api-reference/models
 */
@Data
public class Permission {
	public String id;

	public String object;

	public long created;

	@JsonProperty("allow_create_engine")
	public boolean allowCreateEngine;

	@JsonProperty("allow_sampling")
	public boolean allowSampling;

	@JsonProperty("allow_logprobs")
	public boolean allowLogProbs;

	@JsonProperty("allow_search_indices")
	public boolean allowSearchIndices;

	@JsonProperty("allow_view")
	public boolean allowView;

	@JsonProperty("allow_fine_tuning")
	public boolean allowFineTuning;

	public String organization;

	public String group;

	@JsonProperty("is_blocking")
	public boolean isBlocking;

}
