package com.shaw.openai;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

/**
 * 拦截器设置 Bearer + token
 */
public class AuthenticationInterceptor implements ClientHttpRequestInterceptor {

	private final String token;

	AuthenticationInterceptor(String token) {
		this.token = token;
	}

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		request.getHeaders().add(HttpHeaders.AUTHORIZATION, "Bearer " + token);
		return execution.execute(request, body);
	}

}
