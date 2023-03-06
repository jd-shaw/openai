package com.shaw.openai.api.moderation;

import lombok.Data;
import lombok.ToString;

/**
 * @author shaw
 * @date 2023/2/28
 *
 *  https://platform.openai.com/docs/api-reference/moderations/create
 */
@Data
public class Moderation {
	/**
	 * 如果模型将内容分类为违反OpenAI的内容策略，则设置为true，否则设置为false
	 */
	public boolean flagged;

	/**
	 *包含每类别二进制内容策略冲突标志的对象。
	 *对于每个类别，如果模型将相应类别标记为违反，则值为true，否则为false。
	 */
	public ModerationCategories categories;

	/**
	 *对象，包含模型输出的每个类别的原始分数，表示模型对
	 *输入违反了OpenAI的类别策略。
	 *该值介于0和1之间，其中较高的值表示较高的置信度。
	 *分数不应解释为概率。
	 */
	public ModerationCategoryScores categoryScores;
}
