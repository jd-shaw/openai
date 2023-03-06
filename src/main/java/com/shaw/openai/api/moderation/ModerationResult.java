package com.shaw.openai.api.moderation;

import java.util.List;

import lombok.Data;

/**
 * @author shaw
 * @date 2023/2/28
 *
 * https://beta.openai.com/docs/api-reference/moderations/create
 */
@Data
public class ModerationResult {

	public String id;

	public String model;

	public List<Moderation> results;
}
