package com.shaw.openai;

import org.junit.Test;

import com.shaw.openai.api.OpenAiResponse;
import com.shaw.openai.api.model.Model;

/**
 * @author shaw
 * @date 2023/2/28
 */
public class ModelTest {

	OpenAi service = OpenAiService.getInstance();

	@Test
	public void listModels() {
		OpenAiResponse<Model> models = service.listModels();
		System.out.println(models);
	}

	@Test
	public void getModel() {
		Model ada = service.getModel("babbage");
		System.out.println(ada);
	}

}
