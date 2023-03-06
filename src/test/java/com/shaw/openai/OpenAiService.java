package com.shaw.openai;

/**
 * @author shaw
 * @date 2023/2/28
 */
public class OpenAiService {

	private static volatile OpenAi instance = null;

	private OpenAiService() {
	}

	public static OpenAi getInstance() {
		if (instance == null) {
			synchronized (OpenAi.class) {
				if (instance == null) {
					instance = new OpenAi("YOUR API KEY");
				}
			}
		}
		return instance;
	}

}
