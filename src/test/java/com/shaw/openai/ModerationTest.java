package com.shaw.openai;

import org.junit.Test;

import com.shaw.openai.api.moderation.Moderation;
import com.shaw.openai.api.moderation.ModerationRequest;

/**
 * @author shaw
 * @date 2023/2/28
 */
public class ModerationTest {

	OpenAi service = OpenAiService.getInstance();

	@Test
	public void createModeration() {
		ModerationRequest moderationRequest = ModerationRequest.builder().input("I want to kill them")
				.model("text-moderation-latest").build();
		Moderation moderationScore = service.createModeration(moderationRequest).getResults().get(0);
		System.out.println(moderationScore);
	}
}
