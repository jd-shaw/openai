package com.shaw.openai.api.engine;

import lombok.Data;

/**
 * @author shaw
 * @date 2023/2/28
 *
 *  https://platform.openai.com/docs/api-reference/retrieve-engine
 */
@Deprecated
@Data
public class Engine {

	public String id;

	public String object;

	public String owner;

	public boolean ready;
}
