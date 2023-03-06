package com.shaw.openai.api.finetune;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author shaw
 * @date 2023/2/28
 *
 *  https://platform.openai.com/docs/api-reference/fine-tunes
 */
@Data
public class FineTuneEvent {
	/**
	 * 返回数据类型，一般为： "fine-tune-event".
	 */
	String object;

	/**
	 * 创建时间
	 */
	@JsonProperty("created_at")
	Long createdAt;

	/**
	 * 事件信息级别
	 */
	String level;

	/**
	 * 事件信息
	 */
	String message;
}
