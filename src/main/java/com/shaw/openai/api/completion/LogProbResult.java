package com.shaw.openai.api.completion;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.shaw.openai.api.completion.code.CompletionRequest;
import lombok.Data;

/**
 * @author shaw
 * @date 2023/2/28
 *
 *  https://platform.openai.com/docs/api-reference/create-completion
 */
@Data
public class LogProbResult {

	/**
	 * 完成api选择的令牌
	 */
	private List<String> tokens;

	/**
	 *  {@link tokens}中每个令牌的对数概率
	 */
	@JsonProperty("token_logprobs")
	private List<Double> tokenLogprobs;

	/**
	 * 完成结果中每个索引的映射。
	 * *该映射包含顶部{@link CompletionRequest#logprobs}标记及其概率
	 */
	@JsonProperty("top_logprobs")
	private List<Map<String, Double>> topLogprobs;

	/**
	 * 每个所选标记从返回文本开头的字符偏移量。
	 */
	@JsonProperty("text_off_set")
	private List<Integer> textOffset;
}
