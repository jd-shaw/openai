package com.shaw.openai.api.finetune;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
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
 *  https://platform.openai.com/docs/api-reference/fine-tunes/create
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FineTuneRequest {

	/**
	 *	 包含训练数据的已上传文件的唯一标识符。
	 */
	@NonNull
	@JsonProperty("training_file")
	String trainingFile;

	/**
	 *	 包含验证数据的已上传文件的唯一标识符。
	 */
	@JsonProperty("validation_file")
	String validationFile;

	/**
	 *	 要微调的基础模型的名称。可选值为“ada”、“babbage”、“curie”或“davinci”。要了解这些模型的详细信息，请参阅引擎文档。
	 */
	String model;

	/**
	 *	 训练模型的时期数。一个时期是指完整训练数据集的一次循环。
	 */
	@JsonProperty("n_epochs")
	Integer nEpochs;

	/**
	 *	 用于训练的批次大小。
	 * 批次大小是用于训练单个向前和向后传递的训练示例的数量。
	 * 默认情况下，批次大小将动态配置为训练集中示例数量的约0.2%，上限为256 - 通常情况下，我们发现较大的批次大小 tend to work better for larger datasets.
	 */
	@JsonProperty("batch_size")
	Integer batchSize;

	/**
	 ** 用于训练的学习率乘数。
	 * 微调学习率是用于预训练的原始学习率乘以该值。
	 * 默认情况下，学习率乘数为0.05、0.1或0.2，具体取决于最终的batch_size（较大的学习率 tend to perform better with larger batch sizes）。
	 * 我们建议在0.02到0.2的范围内尝试不同的值，以查看哪些值可以产生最佳结果。
	 */
	@JsonProperty("learning_rate_multiplier")
	Double learningRateMultiplier;

	/**
	 * 用于prompt tokens的损失权重。
	 * 这控制模型试图学习生成prompt的程度（与始终具有1.0权重的完成相比），
	 * 并且在完成较短时可以添加稳定效果。
	 * 如果prompt非常长（相对于完成），则可能有必要降低该权重，以避免过度优先考虑学习prompt。
	 */
	@JsonProperty("prompt_loss_weight")
	Double promptLossWeight;

	/**
	 * 如果设置，我们将使用验证集在每个时期结束时计算特定于分类的度量标准，例如准确性和F-1分数。这些指标可以在结果文件中查看。
	 * 为了计算分类指标，必须提供validation_file。
	 * 此外，必须为多类分类指定{@link FineTuneRequest#classificationNClasses}或为二元分类指定{@link FineTuneRequest#classificationPositiveClass}。
	 */
	@JsonProperty("compute_classification_metrics")
	Boolean computeClassificationMetrics;

	/**
	 * 分类任务中的类数。
	 * 此参数对于多类分类是必需的。
	 */
	@JsonProperty("classification_n_classes")
	Integer classificationNClasses;

	/**
	 * 二元分类中的正类。
	 * 在进行二元分类时，需要此参数以生成精确度、召回率和F1度量标准。
	 */
	@JsonProperty("classification_positive_class")
	String classificationPositiveClass;

	/**
	 * 如果提供了此参数，则计算指定 beta 值的 F-beta 分数。F-beta 分数是 F-1 分数的一般化。仅用于二元分类。
	 * 当 beta=1 时（即 F-1 分数），精确率和召回率权重相等。
	 * beta 值越大，召回率的权重就越大，精确率的权重就越小。
	 * beta 值越小，精确率的权重就越大，召回率的权重就越小。
	 */
	@JsonProperty("classification_betas")
	List<Double> classificationBetas;

	/**
	 * 最多 40 个字符的字符串，将添加到您的微调模型名称中。
	 */
	String suffix;
}
