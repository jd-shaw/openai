package com.shaw.openai.api.embedding;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * @author shaw
 * @date 2023/2/28
 *
 *  https://platform.openai.com/docs/api-reference/embeddings/create
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmbeddingRequest {

	/**
	 *要使用的模型的名称。
	 *如果使用新的v1/embeddings端点，则为必需。
	 */
	String model;

	/**
	 * 输入文本以获取嵌入，编码为字符串或标记数组。
	 * 要在单个请求中获取多个输入的嵌入，请传递字符串数组或令牌数组数组。
	 *
	 * 每个输入的长度不得超过2048个令牌。
	 * ＜p＞
	 * 除非您正在嵌入代码，否则我们建议用单个空格替换输入中的换行符（\n），
	 * 正如我们观察到的，当出现换行符时，结果较差。
	 */
	@NonNull
	List<String> input;

	/**
	 * 代表最终用户的唯一标识符，它将帮助OpenAI监控和检测滥用。
	 */
	String user;

}
