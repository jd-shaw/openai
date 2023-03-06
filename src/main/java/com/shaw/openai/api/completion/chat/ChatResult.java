package com.shaw.openai.api.completion.chat;

import java.util.List;

import com.shaw.openai.api.Usage;

import lombok.Data;

/**
 * @author shaw
 * @date 2023/3/2
 *
 * https://platform.openai.com/docs/api-reference/chat/create
 */
@Data
public class ChatResult {

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

	private List<ChatChoice> choices;

	/**
	 * apii用量
	 */
	private Usage usage;

}
