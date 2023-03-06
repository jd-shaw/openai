package com.shaw.openai.api.completion.chat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author shaw
 * @date 2023/3/2
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {

	/**
	 * “system”, “user”, or “assistant”
	 */
	private String role;

	/**
	 * 内容
	 */
	private String content;

}
