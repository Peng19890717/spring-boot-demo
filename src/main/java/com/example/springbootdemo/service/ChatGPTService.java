package com.example.springbootdemo.service;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pengliu
 */
@Slf4j
public class ChatGPTService {
    private static final String API_URL = "https://api.openai.com/v1/chat/completions";
    private static final String API_KEY = "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";

    private CloseableHttpClient httpClient;

    @PostConstruct
    private void init() {
        this.httpClient = HttpClients.createDefault();
    }

    @PreDestroy
    private void close() throws IOException {
        this.httpClient.close();
    }

    public String generateResponse(String input) throws IOException {
        HttpPost httpPost = new HttpPost(API_URL);
        httpPost.setHeader("Content-Type", "application/json");
        httpPost.setHeader("Authorization", "Bearer " + API_KEY);
        Map map = new HashMap<>();

        map.put("messages", "[{\"role\": \"user\", \"content\": \"Say this is a test!\"}]");
        map.put("model","gpt-3.5-turbo");
        map.put("temperature", 0.5);

        httpPost.setEntity(new StringEntity(JSON.toJSONString(map), StandardCharsets.UTF_8));

        try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
            log.info(JSON.toJSONString(response));
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                throw new RuntimeException("Failed to generate response from ChatGPT API");
            }
            HttpEntity entity = response.getEntity();
            if (entity == null) {
                throw new RuntimeException("Empty response from ChatGPT API");
            }
            return EntityUtils.toString(entity, StandardCharsets.UTF_8);
        }
    }
}

