package com.shaw.openai.api.image;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author shaw
 * @date 2023/2/28
 *
 *  https://platform.openai.com/docs/api-reference/images
 */
@Data
public class Image {
	/**
	 * 可以访问图像的URL。
	 */
	String url;

	/**
	 * Base64编码的图像字符串。
	 */
	@JsonProperty("b64_json")
	String b64Json;
}
