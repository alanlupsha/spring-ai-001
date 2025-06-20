package com.tutorials.tutorialspringai2.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.ollama.OllamaApi;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfig {

    @Bean
    public ChatModel ollamaChatModel() {
        var ollamaApi = new OllamaApi("http://localhost:11434");
        return new OllamaChatModel(ollamaApi, "llama3");
    }

    @Bean
    public ChatClient chatClient(ChatModel ollamaChatModel) {
        return ChatClient.builder(ollamaChatModel).build();
    }
}
