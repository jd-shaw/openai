package com.shaw.openai.api;

import java.util.List;

import lombok.Data;

/**
 * @author shaw
 * @date 2023/2/28
 */
@Data
public class OpenAiResponse<T> {

	public List<T> data;

	public String object;

}
