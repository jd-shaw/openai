package com.shaw.openai.api.edit;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * @author shaw
 * @date 2023/2/28
 *
 * https://platform.openai.com/docs/api-reference/edits/create
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EditRequest {

	/**
	 * 使用的模型名称。如果使用新的 v1/edits 端点，则必填。
	 */
	String model;

	/**
	 *  用作编辑起点的输入文本。
	 */
	String input;

	/**
	 *  告诉模型如何编辑提示的指令。例如，“修正拼写错误”。
	 */
	@NonNull
	String instruction;

	/**
	 *  要为输入和指令生成的编辑数量。
	 */
	Integer n;

	/**
	 *  要使用的采样温度。较高的值意味着模型将冒更大的风险。
	 *  尝试 0.9 以进行更有创意的应用，0（argmax 采样）用于有明确定义答案的应用。
	 *  我们通常建议更改此参数或 {@link EditRequest#topP}，但不建议两者同时更改。
	 */
	Double temperature;

	/**
	 *  一种替代采样温度的方法，称为 nucleus 采样，
	 *  其中模型考虑具有 top_p 概率质量的令牌的结果。因此，0.1 表示仅考虑组成前 10％ 概率质量的令牌。
	 *  我们通常建议更改此参数或 {@link EditRequest#temperature}，但不建议两者同时更改。
	 */
	@JsonProperty("top_p")
	Double topP;
}
