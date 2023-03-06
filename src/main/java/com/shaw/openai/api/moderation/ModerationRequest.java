package com.shaw.openai.api.moderation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * @author shaw
 * @date 2023/2/28
 *
 * https://beta.openai.com/docs/api-reference/moderations/create
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ModerationRequest {

	/**
	 * 要分类的输入文本。
	 */
	@NonNull
	String input;

	/**
	 * 要使用的模型的名称，默认为文本适度稳定
	 */
	String model;
}
