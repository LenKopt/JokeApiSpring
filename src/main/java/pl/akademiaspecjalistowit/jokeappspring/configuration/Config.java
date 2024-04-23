package pl.akademiaspecjalistowit.jokeappspring.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.http.HttpClient;
import java.util.Random;

@Configuration
public class Config {
    @Bean
    public HttpClient httpClient() {
        return  HttpClient.newHttpClient();
    }
    @Bean
    public ObjectMapper objectMapper() {
        return  new ObjectMapper();
    }
    @Bean
    public Random random() {
        return  new Random();
    }
}
