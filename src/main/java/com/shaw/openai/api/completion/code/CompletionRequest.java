package com.shaw.openai.api.completion.code;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author shaw
 * @date 2023/2/28
 *
 * https://platform.openai.com/docs/api-reference/completions/create
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompletionRequest {

	/**
	 *要使用的模型的名称。
	 *如果指定了微调模型或使用了新的v1/completions端点，则需要此选项。
	 */
	private String model;

	private String prompt;

	/**
	 *要生成的最大令牌数。
	 *请求最多可以使用2048个在提示和完成之间共享的令牌。
	 *（普通英语文本的一个标记大约为4个字符）
	 */
	@JsonProperty("max_tokens")
	private Integer maxTokens;

	/**
	 *使用什么样的采样温度。更高的值意味着模型将承担更多的风险。
	 *对于更具创意的应用程序，请尝试0.9，对于答案明确的应用程序请尝试0（argmax采样）。
	 *
	 *我们通常建议使用this或 {@link CompletionRequest#topP} ，但不能同时使用这两者。
	 */
	private Double temperature = 0d;

	/**
	 * Nucleus采样是一种替代使用温度参数的采样方式，模型会考虑概率分布在top_p中的所有token。例如，top_p=0.1表示只有组成前10%概率分布的token被考虑。
	 * 通常我们建议使用此参数或{@link CompletionRequest#temperature}参数中的一个，而不是同时使用两个。
	 */
	@JsonProperty("top_p")
	private Double topP = 1d;

	/**
	 * 每个prompt生成的完成数。
	 * 由于此参数会生成大量的完成结果，因此可能会快速消耗您的token配额。请谨慎使用，并确保您合理设置了{@link CompletionRequest#maxTokens}和{@link CompletionRequest#stop}参数。
	 */
	private Integer n;

	/**
	 * 是否在部分完成时返回数据流。
	 * 如果设置了此参数，则仅当可用时，tokens将作为数据流事件发送，流将以数据: DONE消息终止。
	 */
	private Boolean stream = false;

	/**
	 * 是否在logprobs最大的tokens中包括tokens的对数概率值，以及所选择的tokens。
	 * 例如，如果logprobs=10，则API将返回10个最有可能的tokens的对数概率值。
	 * API始终会返回所抽样token的对数概率值，因此响应中可能有logprobs + 1个元素。
	 */
	private Integer logprobs = 0;

	/**
	 * 是否在完成结果中包括输入的prompt。
	 */
	private Boolean echo = false;

	/**
	 * 最多4个序列，API将在这些序列后停止生成更多tokens。
	 * 返回的文本将不包含停止序列。
	 */
	private List<String> stop;

	/**
	 * 0到1之间的数字（默认为0），根据新token在当前文本中的出现情况对其进行惩罚。
	 * 增加模型谈论新话题的可能性。
	 */
	@JsonProperty("presence_penalty")
	private Double presencePenalty = 0d;

	/**
	 * 0到1之间的数字（默认为0），根据新token在当前文本中的出现频率对其进行惩罚。
	 * 减少模型逐字重复同一句话的可能性。
	 */
	@JsonProperty("frequency_penalty")
	private Double frequencyPenalty = 0d;

	/**
	 * 在服务器端生成best_of个完成结果，并返回“最佳”（每个token的对数概率最低的完成结果）。
	 * 结果不能被实时返回。
	 * 当与{@link CompletionRequest#n}一起使用时，best_of参数控制候选完成的数量，n参数指定要返回的数量，
	 best_of必须大于n。
	 */
	@JsonProperty("best_of")
	private Integer bestOf;

	/**
	 * 修改指定tokens出现在完成结果中的概率。
	 * 将tokens（由GPT tokenizer中的token ID指定）映射到从-100到100的相关偏置值。
	 * https://platform.openai.com/docs/api-reference/completions/create#completions/create-logit_bias
	 */
	@JsonProperty("logit_bias")
	private Map<String, Integer> logitBias;

	/**
	 * 表示您的最终用户的唯一标识符，将帮助OpenAI监视和检测滥用行为。
	 */
	private String user;
}
