package com.shaw.openai;

import java.util.List;

import org.junit.Test;

import com.shaw.openai.api.image.CreateImageEditRequest;
import com.shaw.openai.api.image.CreateImageRequest;
import com.shaw.openai.api.image.CreateImageVariationRequest;
import com.shaw.openai.api.image.Image;

/**
 * @author shaw
 * @date 2023/2/28
 */
public class ImageTest {

	static String filePath = "/Users/xiaojindong/Downloads/cat.png";
	static String fileWithAlphaPath = "/Users/xiaojindong/Downloads/cat_with_alpha.png";
	static String maskPath = "/Users/xiaojindong/Downloads/mask.png";

	OpenAi service = OpenAiService.getInstance();

	@Test
	public void createImageUrl() {
		CreateImageRequest createImageRequest = CreateImageRequest.builder().prompt("a white siamese cat").n(3)
				.size("1024x1024").build();
		List<Image> images = service.createImage(createImageRequest).getData();
		System.out.println(images);
	}

	@Test
	public void createImageBase64() {
		CreateImageRequest createImageRequest = CreateImageRequest.builder().prompt("a white siamese cat")
				.responseFormat("b64_json").user("testing").build();

		List<Image> images = service.createImage(createImageRequest).getData();
		System.out.println(images);
	}

	@Test
	public void createImageEdit() {
		CreateImageEditRequest createImageRequest = CreateImageEditRequest.builder()
				.prompt("a cat with a red background").responseFormat("url").size("256x256").user("testing").n(2)
				.build();
		List<Image> images = service.createImageEdit(createImageRequest, fileWithAlphaPath, null).getData();
		System.out.println(images);
	}

	@Test
	public void createImageEditWithMask() {
		CreateImageEditRequest createImageRequest = CreateImageEditRequest.builder().prompt("a cat with a red hat")
				.responseFormat("url").size("256x256").user("testing").n(2).build();

		List<Image> images = service.createImageEdit(createImageRequest, filePath, maskPath).getData();
		System.out.println(images);
	}

	@Test
	public void createImageVariation() {
		CreateImageVariationRequest createImageVariationRequest = CreateImageVariationRequest.builder()
				.responseFormat("url").size("256x256").user("testing").n(2).build();

		List<Image> images = service.createImageVariation(createImageVariationRequest, filePath).getData();
		System.out.println(images);
	}
}
