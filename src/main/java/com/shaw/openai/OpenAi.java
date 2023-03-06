package com.shaw.openai;

import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.shaw.openai.api.completion.chat.ChatResult;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.shaw.openai.api.DeleteResult;
import com.shaw.openai.api.OpenAiError;
import com.shaw.openai.api.OpenAiHttpException;
import com.shaw.openai.api.OpenAiResponse;
import com.shaw.openai.api.completion.chat.ChatRequest;
import com.shaw.openai.api.completion.code.CompletionRequest;
import com.shaw.openai.api.completion.code.CompletionResult;
import com.shaw.openai.api.edit.EditRequest;
import com.shaw.openai.api.edit.EditResult;
import com.shaw.openai.api.embedding.EmbeddingRequest;
import com.shaw.openai.api.embedding.EmbeddingResult;
import com.shaw.openai.api.file.File;
import com.shaw.openai.api.finetune.FineTuneEvent;
import com.shaw.openai.api.finetune.FineTuneRequest;
import com.shaw.openai.api.finetune.FineTuneResult;
import com.shaw.openai.api.image.CreateImageEditRequest;
import com.shaw.openai.api.image.CreateImageRequest;
import com.shaw.openai.api.image.CreateImageVariationRequest;
import com.shaw.openai.api.image.ImageResult;
import com.shaw.openai.api.model.Model;
import com.shaw.openai.api.moderation.ModerationRequest;
import com.shaw.openai.api.moderation.ModerationResult;

import lombok.extern.slf4j.Slf4j;

/**
 * @author shaw
 * @date 2023/2/28
 */
@Slf4j
public class OpenAi {

	private static final String BASE_URL = "https://api.openai.com";
	private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(120);
	private static final ObjectMapper errorMapper = defaultObjectMapper();
	private final RestTemplate restTemplate;

	/**
	 * 创建OpenAiService
	 *
	 * @param token OpenAi token ： "sk-XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"
	 */
	public OpenAi(final String token) {
		this(token, DEFAULT_TIMEOUT);
	}

	/**
	 * 创建OpenAiService
	 *
	 * @param token   OpenAi token ： "sk-XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"
	 * @param timeout Http超时, Duration.ZERO 意味着不超时
	 */
	public OpenAi(final String token, final Duration timeout) {
		this.restTemplate = buildRestTemplate(token, timeout);
	}

	private RestTemplate getRestTemplate() {
		return restTemplate;
	}

	public OpenAiResponse<Model> listModels() {
		return execute("/v1/models", HttpMethod.GET, getHttpEntity(null),
				new ParameterizedTypeReference<OpenAiResponse<Model>>() {
				});
	}

	public Model getModel(String modelId) {
		return execute("/v1/models/{model_id}", HttpMethod.GET, getHttpEntity(null), Model.class, modelId);
	}

	public CompletionResult createCompletion(CompletionRequest request) {
		return execute("/v1/completions", HttpMethod.POST, getHttpEntity(request), CompletionResult.class);
	}

	public ChatResult createChatCompletion(ChatRequest request) {
		return execute("/v1/chat/completions", HttpMethod.POST, getHttpEntity(request), ChatResult.class);
	}

	public EditResult createEdit(EditRequest request) {
		return execute("/v1/edits", HttpMethod.POST, getHttpEntity(request), EditResult.class);
	}

	public EmbeddingResult createEmbeddings(EmbeddingRequest request) {
		return execute("/v1/embeddings", HttpMethod.POST, getHttpEntity(request), EmbeddingResult.class);
	}

	public OpenAiResponse<File> listFiles() {
		return execute("/v1/files", HttpMethod.GET, getHttpEntity(null),
				new ParameterizedTypeReference<OpenAiResponse<File>>() {
				});
	}

	public DeleteResult deleteFile(String fileId) {
		return execute("/v1/files/{file_id}", HttpMethod.DELETE, getHttpEntity(null), DeleteResult.class, fileId);
	}

	public File retrieveFile(String fileId) {
		return execute("/v1/files/{file_id}", HttpMethod.POST, getHttpEntity(null), File.class, fileId);
	}

	public File uploadFile(String purpose, java.io.File file) {
		MultiValueMap<String, Object> requestBody = new LinkedMultiValueMap<>();
		requestBody.add("purpose", purpose);
		requestBody.add("file", new FileSystemResource(file));
		Map<String, Object> headerMaps = new HashMap<>();
		headerMaps.put(HttpHeaders.CONTENT_TYPE, MediaType.MULTIPART_FORM_DATA_VALUE);
		return execute("/v1/files", HttpMethod.POST, getHttpEntity(requestBody, headerMaps), File.class);
	}

	public FineTuneResult createFineTune(FineTuneRequest request) {
		return execute("/v1/fine-tunes", HttpMethod.POST, getHttpEntity(request), FineTuneResult.class);
	}

	public CompletionResult createFineTuneCompletion(CompletionRequest request) {
		return execute("/v1/completions", HttpMethod.POST, getHttpEntity(request), CompletionResult.class);
	}

	public OpenAiResponse<FineTuneResult> listFineTunes() {
		return execute("/v1/fine-tunes", HttpMethod.GET, null,
				new ParameterizedTypeReference<OpenAiResponse<FineTuneResult>>() {
				});
	}

	public FineTuneResult retrieveFineTune(String fineTuneId) {
		return execute("/v1/fine-tunes/" + fineTuneId, HttpMethod.GET, null, FineTuneResult.class);
	}

	public FineTuneResult cancelFineTune(String fineTuneId) {
		return execute("/v1/fine-tunes/" + fineTuneId + "/cancel", HttpMethod.POST, null, FineTuneResult.class);
	}

	public OpenAiResponse<FineTuneEvent> listFineTuneEvents(String fineTuneId) {
		return execute("/v1/fine-tunes/" + fineTuneId + "/events", HttpMethod.GET, null,
				new ParameterizedTypeReference<OpenAiResponse<FineTuneEvent>>() {
				});
	}

	public DeleteResult deleteFineTune(String fineTuneId) {
		return execute("/v1/models/" + fineTuneId, HttpMethod.DELETE, null, DeleteResult.class);
	}

	public ImageResult createImage(CreateImageRequest request) {
		return execute("/v1/images/generations", HttpMethod.POST, getHttpEntity(request), ImageResult.class);
	}

	public ImageResult createImageEdit(CreateImageEditRequest request, String imagePath, String maskPath) {
		java.io.File image = new java.io.File(imagePath);
		java.io.File mask = null;
		if (maskPath != null) {
			mask = new java.io.File(maskPath);
		}
		return createImageEdit(request, image, mask);
	}

	public ImageResult createImageEdit(CreateImageEditRequest request, java.io.File image, java.io.File mask) {
		MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
		body.add("size", request.getSize());
		body.add("prompt", request.getPrompt());
		body.add("response_format", request.getResponseFormat());
		body.add("image", new FileSystemResource(image));

		if (request.getN() != null) {
			body.add("n", request.getN());
		}

		if (mask != null) {
			body.add("mask", new FileSystemResource(mask));
		}

		Map<String, Object> header = new HashMap<>();
		header.put(HttpHeaders.CONTENT_TYPE, MediaType.MULTIPART_FORM_DATA_VALUE);

		return execute("/v1/images/edits", HttpMethod.POST, getHttpEntity(body, header), ImageResult.class);
	}

	public ImageResult createImageVariation(CreateImageVariationRequest request, String imagePath) {
		java.io.File image = new java.io.File(imagePath);
		return createImageVariation(request, image);
	}

	public ImageResult createImageVariation(CreateImageVariationRequest request, java.io.File image) {
		MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
		body.add("size", request.getSize());
		body.add("response_format", request.getResponseFormat());
		body.add("image", new FileSystemResource(image));

		Map<String, Object> header = new HashMap<>();
		header.put(HttpHeaders.CONTENT_TYPE, MediaType.MULTIPART_FORM_DATA_VALUE);

		return execute("/v1/images/variations", HttpMethod.POST, getHttpEntity(body, header), ImageResult.class);
	}

	public ModerationResult createModeration(ModerationRequest request) {
		return execute("/v1/moderations", HttpMethod.POST, getHttpEntity(request), ModerationResult.class);
	}

	private <T> T execute(String url, HttpMethod method, HttpEntity<?> entity, Class<T> responseType,
			Object... uriVariables) {
		try {
			ResponseEntity<T> responseEntity = restTemplate.exchange(BASE_URL + url, method, entity, responseType,
					uriVariables);
			return responseEntity.getBody();
		} catch (HttpClientErrorException e) {
			try {
				String errorBody = e.getResponseBodyAsString();
				OpenAiError error = errorMapper.readValue(errorBody, OpenAiError.class);
				throw new OpenAiHttpException(error, e, e.getStatusCode().value());
			} catch (IOException ex) {
				throw e;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private <T> T execute(String url, HttpMethod method, HttpEntity<?> entity,
			ParameterizedTypeReference<T> responseType) {
		try {
			ResponseEntity<T> responseEntity = restTemplate.exchange(BASE_URL + url, method, entity, responseType);
			return responseEntity.getBody();
		} catch (HttpClientErrorException e) {
			try {
				String errorBody = e.getResponseBodyAsString();
				OpenAiError error = errorMapper.readValue(errorBody, OpenAiError.class);
				throw new OpenAiHttpException(error, e, e.getStatusCode().value());
			} catch (IOException ex) {
				throw e;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private HttpEntity<Object> getHttpEntity(Object request) {
		return getHttpEntity(request, null);
	}

	private HttpEntity<Object> getHttpEntity(Object request, Map<String, Object> headerMaps) {
		if (headerMaps != null) {
			HttpHeaders headers = new HttpHeaders();
			for (Map.Entry<String, Object> entry : headerMaps.entrySet()) {
				headers.add(entry.getKey(), (String) entry.getValue());
			}
			return new HttpEntity<>(request, headers);
		} else {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			return new HttpEntity<>(request, headers);
		}
	}

	private static ObjectMapper defaultObjectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
		return mapper;
	}

	private static RestTemplate buildRestTemplate(String token, Duration timeout) {
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setConnectTimeout((int) timeout.toMillis());
		requestFactory.setReadTimeout((int) timeout.toMillis());
		RestTemplate restTemplate = new RestTemplate(requestFactory);

		restTemplate.setInterceptors(Collections.singletonList(new AuthenticationInterceptor(token)));

		restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
			@Override
			public boolean hasError(ClientHttpResponse response) throws IOException {
				HttpStatus statusCode = response.getStatusCode();
				return statusCode.is4xxClientError() || statusCode.is5xxServerError();
			}
		});

		restTemplate.getMessageConverters().add(new FormHttpMessageConverter());
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

		return restTemplate;
	}

}
