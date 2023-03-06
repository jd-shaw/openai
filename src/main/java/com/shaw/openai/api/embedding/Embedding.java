package com.shaw.openai.api.embedding;

import java.util.List;

import lombok.Data;
import lombok.ToString;

/**
 * @author shaw
 * @date 2023/2/28
 *
 *  https://platform.openai.com/docs/api-reference/classifications/create
 */
@Data
public class Embedding {

	/**
	 * 返回的对象类型应为“embedding”
	 */
	String object;

	/**
	 * 向量
	 */
	List<Double> embedding;

	/**
	 * 在列表中的位置
	 */
	Integer index;
}
