package com.shaw.openai.api.completion;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shaw.openai.api.completion.code.CompletionRequest;
import lombok.Data;

/**
 * @author shaw
 * @date 2023/2/28
 *  https://platform.openai.com/docs/api-reference/completions/create
 */
@Data
public class CompletionChoice {

	/**
	 *  生成的文本。如果{@link CompletionRequest#echo }为true，则会包括提示
	 */
	private String text;

	/**
	 *  返回列表中此完成的索引。
	 */
	private Integer index;

	/**
	 * 所选令牌和前{@link CompletionRequest#logprobs}个令牌的对数概率
	 */
	private LogProbResult logprobs;

	/**
	 * 停止生成的原因，例如“length”。
	 */
	@JsonProperty("finish_reason")
	private String finishReason;
}
