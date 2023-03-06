package com.shaw.openai.api.common;

/**
 * @author shaw
 * @date 2023/3/2
 */
public class StaticValues {

	public static class Image {
		public static class Size {
			public static final String SIZE256 = "256x256";
			public static final String SIZE512 = "512x512";
			public static final String SIZE1024 = "1024x1024";
		}

		public static class ResponseFormat {
			public static final String URL = "url";
			public static final String BASE64 = "b64_json";
		}
	}

	public static class ChatMessageRoles {
		public static final String SYSTEM = "system";
		public static final String USER = "user";
		public static final String ASSISTANT = "assistant";
	}

}
