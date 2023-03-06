package com.shaw.openai.api;

import lombok.Data;

/**
 * @author shaw
 * @date 2023/2/28
 */
@Data
public class DeleteResult {
	/**
	 * id
	 */
	private String id;

	/**
	 * 删除数据类型： "file" or "model"
	 */
	private String object;

	/**
	 * 删除状态成功、失败
	 */
	private boolean deleted;
}
