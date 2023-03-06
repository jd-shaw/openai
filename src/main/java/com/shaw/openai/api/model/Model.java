package com.shaw.openai.api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @author shaw
 * @date 2023/2/28
 *
 *  https://platform.openai.com/docs/api-reference/models
 */
@Data
public class Model {
	/**
	 * 此模型的标识符，用于在完成等时指定模型
	 */
	public String id;

	/**
	 * 返回的对象类型应为“model”
	 */
	public String object;

	/**
	 * GPT-3模型的所有者，通常是“openai”
	 */
	@JsonProperty("owned_by")
	public String ownedBy;

	/**
	 * 此模型的权限列表
	 */
	public List<Permission> permission;

	/**
	 * 此及其父级（如果适用）所基于的根模型
	 */
	public String root;

	/**
	 * 这是基于的父模型
	 */
	public String parent;
}
