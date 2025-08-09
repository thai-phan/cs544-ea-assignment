package search;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.web.client.RestClientCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatClientConfig {

    @Bean
    public ChatClient chatClient(ChatClient.Builder chatClientBuilder) {
        return chatClientBuilder.build();
    }

    @Bean
    public RestClientCustomizer aiLoggingRestClientCustomizer() {
        return restClientBuilder -> restClientBuilder.requestInterceptor(new AIRequestLogInterceptor());
    }
}