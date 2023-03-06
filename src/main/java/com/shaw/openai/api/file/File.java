package com.shaw.openai.api.file;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author shaw
 * @date 2023/2/28
 *
 *  https://platform.openai.com/docs/api-reference/files
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class File {

	/**
	 * 文件的唯一ID。
	 */
	String id;

	/**
	 * 返回的对象类型，应为“file”。
	 */
	String object;

	/**
	 * 文件大小（以字节为单位）。
	 */
	Long bytes;

	/**
	 * 创建时间，以epoch秒为单位。
	 */
	@JsonProperty("created_at")
	Long createdAt;

	/**
	 * 文件的名称。
	 */
	@JsonProperty("file_name")
	String filename;

	/**
	 *	 文件用途的描述。
	 */
	String purpose;

}
