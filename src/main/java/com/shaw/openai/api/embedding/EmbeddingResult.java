package com.shaw.openai.api.embedding;

import java.util.List;

import com.shaw.openai.api.Usage;

import lombok.Data;

/**
 * @author shaw
 * @date 2023/2/28
 *
 *  https://platform.openai.com/docs/api-reference/embeddings/create
 */
@Data
public class EmbeddingResult {

	/**
	 *用于生成Embedding的GPT-3模型
	 */
	String model;

	/**
	 *返回的对象类型应为“列表”
	 */
	String object;

	/**
	 * 计算Embedding的列表
	 */
	List<Embedding> data;

	/**
	 * 此请求的API用量
	 */
	Usage usage;
}
