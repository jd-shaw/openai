package com.shaw.openai;

import org.junit.Test;

import com.shaw.openai.api.OpenAiHttpException;
import com.shaw.openai.api.edit.EditRequest;
import com.shaw.openai.api.edit.EditResult;

/**
 * @author shaw
 * @date 2023/2/28
 */
public class EditTest {

	OpenAi service = OpenAiService.getInstance();

	@Test
	public void edit() throws OpenAiHttpException {
		EditRequest request = EditRequest.builder().model("text-davinci-edit-001").input("What's you names?")
				.instruction("fix the spelling mistakes").build();

		EditResult edit = service.createEdit(request);
		System.out.println(edit);
	}
}
