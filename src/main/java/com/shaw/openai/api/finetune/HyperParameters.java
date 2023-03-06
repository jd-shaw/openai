package com.shaw.openai.api.finetune;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author shaw
 * @date 2023/2/28
 *
 *  https://platform.openai.com/docs/api-reference/fine-tunes
 */
@Data
public class HyperParameters {

	/**
	 * 用于培训的批次大小。
	 */
	@JsonProperty("batch_size")
	String batchSize;

	/**
	 * 用于培训的学习率乘数。
	 */
	@JsonProperty("learning_rate_multiplier")
	Double learningRateMultiplier;

	/**
	 * 要训练模型的时期数。
	 */
	@JsonProperty("n_epochs")
	Integer nEpochs;

	/**
	 * 用于提示令牌损失的权重。
	 */
	@JsonProperty("prompt_loss_weight")
	Double promptLossWeight;
}
