package com.shaw.openai;

import java.util.List;

import org.junit.Test;

import com.shaw.openai.api.completion.CompletionChoice;
import com.shaw.openai.api.completion.code.CompletionRequest;

/**
 * @author shaw
 * @date 2023/2/28
 */
public class CompletionTest {

	OpenAi service = OpenAiService.getInstance();

	@Test
	public void createCompletion() {

		//		body.put("model", "text-davinci-003"); // 对话模型
		//		body.put("prompt", input + "\n");
		//
		//		body.put("max_tokens", 100);
		//		body.put("top_p", 1);
		//		body.put("temperature", 0);
		//		body.put("frequency_penalty", 0.0);
		//		body.put("presence_penalty", 0.0);

		CompletionRequest completionRequest = CompletionRequest.builder().model("text-davinci-003").prompt("写一首打油诗吧")
				.maxTokens(100).topP(1d).build();
		List<CompletionChoice> choices = service.createCompletion(completionRequest).getChoices();
		System.out.println(choices);
	}
}
