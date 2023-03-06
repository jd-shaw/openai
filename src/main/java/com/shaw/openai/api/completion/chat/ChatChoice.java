package com.shaw.openai.api.completion.chat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author shaw
 * @date 2023/3/2
 */
@Data
public class ChatChoice {

	private ChatMessage delta;

	private ChatMessage message;

	private Integer index;

	@JsonProperty("finish_reason")
	private String finishReason;

}
