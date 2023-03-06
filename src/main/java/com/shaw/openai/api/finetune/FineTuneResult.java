package com.shaw.openai.api.finetune;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shaw.openai.api.file.File;

import lombok.Data;

/**
 * @author shaw
 * @date 2023/2/28
 *
 *  https://platform.openai.com/docs/api-reference/fine-tunes
 */
@Data
public class FineTuneResult {

	/**
	 * fine-tuning任务ID
	 */
	String id;

	/**
	 * 类型： "fine-tune".
	 */
	String object;

	/**
	 * 模型名称
	 */
	String model;

	/**
	 * 创建时间
	 */
	@JsonProperty("created_at")
	Long createdAt;

	List<FineTuneEvent> events;

	/**
	 *经过微调的模型的ID。如果微调作业尚未完成，则为null。这是用于调用模型的ID。
	 */
	@JsonProperty("fine_tuned_model")
	String fineTunedModel;

	/**
	 *微调作业的指定超参数。
	 */
	HyperParameters hyperparams;

	/**
	 *此模型所属组织的ID。
	 */
	@JsonProperty("organization_id")
	String organizationId;

	/**
	 *：此微调作业的结果文件。
	 */
	@JsonProperty("result_files")
	List<File> resultFiles;

	/**
	 *微调作业的状态。可能的值为"pending"、"succeeded"或"cancelled"。
	 */
	String status;

	/**
	 *此微调作业的训练文件。
	 */
	@JsonProperty("validation_files")
	List<File> trainingFiles;

	/**
	 *上次更新时间（以秒为单位）。
	 */
	@JsonProperty("updated_at")
	Long updatedAt;

	/**
	 * 此微调作业的验证文件。
	 */
	@JsonProperty("validation_files")
	List<File> validationFiles;
}
