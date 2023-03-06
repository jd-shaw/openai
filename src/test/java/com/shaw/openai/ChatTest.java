package com.shaw.openai;

import java.util.ArrayList;
import java.util.List;

import com.shaw.openai.api.common.StaticValues;
import org.junit.Test;

import com.shaw.openai.api.completion.chat.ChatRequest;
import com.shaw.openai.api.completion.chat.ChatResult;
import com.shaw.openai.api.completion.chat.ChatMessage;

/**
 * @author shaw
 * @date 2023/3/2
 */
public class ChatTest {

	OpenAi service = OpenAiService.getInstance();

	@Test
	public void createChatCompletion() {
		List<ChatMessage> message = new ArrayList<>();
		message.add(ChatMessage.builder().role(StaticValues.ChatMessageRoles.USER).content("Can you help me?").build());

		ChatRequest completionRequest = ChatRequest.builder().model("gpt-3.5-turbo").messages(message).maxTokens(100)
				.topP(1d).build();
		ChatResult chatCompletion = service.createChatCompletion(completionRequest);
		System.out.println(chatCompletion);
	}

}
