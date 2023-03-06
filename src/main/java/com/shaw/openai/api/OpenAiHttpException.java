package com.shaw.openai.api;

/**
 * @author shaw
 * @date 2023/2/28
 */
public class OpenAiHttpException extends RuntimeException {

	/**
	 * HTTP status code
	 */
	public final int statusCode;

	/**
	 * 错误Code： "invalid_api_key"
	 */
	public final String code;

	public final String param;

	/**
	 * 错误类型： "invalid_request_error"
	 * https://platform.openai.com/docs/guides/error-codes/python-library-error-types
	 */
	public final String type;

	public OpenAiHttpException(OpenAiError error, Exception parent, int statusCode) {
		super(error.getError().getMessage(), parent);
		this.statusCode = statusCode;
		this.code = error.getError().getCode();
		this.param = error.getError().getParam();
		this.type = error.getError().getType();
	}
}
