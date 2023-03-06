package com.shaw.openai.api.edit;

import lombok.Data;

/**
 * @author shaw
 * @date 2023/2/28
 *
 *  https://platform.openai.com/docs/api-reference/edits/create
 */
@Data
public class EditChoice {

	/**
	 * 编辑后的文本。
	 */
	String text;

	/**
	 * 返回列表中此完成的索引。
	 */
	Integer index;
}
