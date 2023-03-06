package com.shaw.openai.api;

import lombok.Data;

/**
 * @author shaw
 * @date 2023/2/28
 */
@Data
public class Usage {
	/**
	 * 使用的提示令牌数。
	 */
	private long promptTokens;

	/**
	 * 使用的完成令牌数。
	 */
	private long completionTokens;

	/**
	 * 使用的令牌总数
	 */
	private long totalTokens;
}
