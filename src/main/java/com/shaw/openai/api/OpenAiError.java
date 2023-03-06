package com.shaw.openai.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author shaw
 * @date 2023/2/28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OpenAiError {

	private OpenAiErrorDetails error;

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class OpenAiErrorDetails {
		/**
		 * 错误消息
		 */
		private String message;

		/**
		 * 错误信息： "invalid_request_error"
		 * https://platform.openai.com/docs/guides/error-codes/python-library-error-types
		 */
		private String type;

		private String param;

		/**
		 * 错误Code： "invalid_api_key"
		 */
		private String code;
	}

}
