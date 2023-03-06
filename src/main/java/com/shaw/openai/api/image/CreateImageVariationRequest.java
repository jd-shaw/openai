package com.shaw.openai.api.image;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

/**
 * @author shaw
 * @date 2023/2/28
 *
 *  https://platform.openai.com/docs/api-reference/images/create-variation
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateImageVariationRequest {

	/**
	 * 要生成的图像数。必须介于1和10之间。默认值为1。
	 */
	Integer n;

	/**
	 * 生成图像的大小。必须是“256x256”、“512x512”或“1024x1024”之一。默认为“1024x1024”。
	 */
	String size;

	/**
	 * 返回生成图像的格式。必须是url或b64_json之一。默认为url。
	 */
	String responseFormat;

	/**
	 * 代表最终用户的唯一标识符，它将帮助OpenAI监控和检测滥用。
	 */
	String user;
}
