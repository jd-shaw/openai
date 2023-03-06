package com.shaw.openai.api.edit;

import java.util.List;

import com.shaw.openai.api.Usage;

import lombok.Data;
import lombok.ToString;

/**
 * @author shaw
 * @date 2023/2/28
 *
 *  https://platform.openai.com/docs/api-reference/edits/create
 */
@Data
@ToString
public class EditResult {

	/**
	 * 返回的对象类型，应为“edit”。
	 */
	public String object;

	/**
	 * 创建时间（以毫秒为单位）。
	 */
	public long created;

	/**
	 * 生成的编辑列表。
	 */
	public List<EditChoice> choices;

	/**
	 * 此请求的 API 使用情况。
	 */
	public Usage usage;
}
