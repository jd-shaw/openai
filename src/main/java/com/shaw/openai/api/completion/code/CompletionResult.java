package com.shaw.openai.api.completion.code;

import java.util.List;

import com.shaw.openai.api.Usage;

import com.shaw.openai.api.completion.CompletionChoice;
import lombok.Data;

/**
 * @author shaw
 * @date 2023/2/28
 *
 *  https://platform.openai.com/docs/api-reference/completions/create
 */
@Data
public class CompletionResult {
	/**
	 * id
	 */
	private String id;

	/**
	 * 返回类型：一般为 "text_completion"
	 */
	private String object;

	/**
	 * 创建时间
	 */
	private long created;

	/**
	 * 使用的model类型
	 */
	private String model;

	private List<CompletionChoice> choices;

	/**
	 * apii用量
	 */
	private Usage usage;
}
