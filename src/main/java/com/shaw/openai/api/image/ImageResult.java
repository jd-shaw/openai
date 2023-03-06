package com.shaw.openai.api.image;

import lombok.Data;

import java.util.List;

/**
 * @author shaw
 * @date 2023/2/28
 *
 *  https://platform.openai.com/docs/api-reference/images
 */
@Data
public class ImageResult {

	/**
	 * 创建时间
	 */
	Long created;

	/**
	 * 结果
	 */
	List<Image> data;
}
