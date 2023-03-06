package com.shaw.openai;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.shaw.openai.api.embedding.Embedding;
import com.shaw.openai.api.embedding.EmbeddingRequest;

/**
 * @author shaw
 * @date 2023/2/28
 */
public class EmbeddingTest {

	OpenAi service = OpenAiService.getInstance();

	@Test
	public void createEmbeddings() {
		EmbeddingRequest embeddingRequest = EmbeddingRequest.builder().model("text-similarity-babbage-001")
				.input(Collections.singletonList("The food was delicious and the waiter...")).build();
		List<Embedding> embeddings = service.createEmbeddings(embeddingRequest).getData();
		System.out.println(embeddings);
	}

	@Test
	public void createEmbeddings2() {
		EmbeddingRequest embeddingRequest = EmbeddingRequest.builder().model("text-embedding-ada-002")
				.input(Collections.singletonList("Korean cuisine (food & drink)")).build();
		List<Embedding> embeddings = service.createEmbeddings(embeddingRequest).getData();
		System.out.println(embeddings);

		EmbeddingRequest embeddingRequest2 = EmbeddingRequest.builder().model("text-embedding-ada-002")
				.input(Collections
						.singletonList("https://www.chicme.com/collection/Red-Dress/1E6W3a1e5J3b0e8c5G9S4q9S4Z.html"))
				.build();
		List<Embedding> embeddings2 = service.createEmbeddings(embeddingRequest2).getData();
		System.out.println(embeddings2);

		double result = cosineSimilarity(embeddings.get(0).getEmbedding(), embeddings2.get(0).getEmbedding());
		System.out.println(result);
	}

	public static double cosineSimilarity(List<Double> embedding, List<Double> target_embedding) {
		double dotProduct = 0.0;
		double normA = 0.0;
		double normB = 0.0;
		for (int i = 0; i < embedding.size(); i++) {
			dotProduct += embedding.get(i) * target_embedding.get(i);
			normA += Math.pow(embedding.get(i), 2);
			normB += Math.pow(target_embedding.get(i), 2);
		}
		return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
	}

}
