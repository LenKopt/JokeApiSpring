package pl.akademiaspecjalistowit.jokeappspring.joke.service.provider;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.akademiaspecjalistowit.jokeappspring.joke.dto.JokeDto;
import pl.akademiaspecjalistowit.jokeappspring.joke.mapper.JokeDtoMapper;
import pl.akademiaspecjalistowit.jokeappspring.joke.model.Joke;

@Service
public class JokeApiProvider implements JokeProvider {

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public JokeApiProvider(HttpClient httpClient, ObjectMapper objectMapper) {

        this.httpClient = httpClient;
        this.objectMapper = objectMapper;
    }

    @Value("${jokes.urls.urlAnyJoke}")
    private String urlAnyJoke;
    @Value("${jokes.urls.urlByCategoryJoke}")
    private String urlByCategoryJoke;

    @Override
    public Joke getJoke() {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(urlAnyJoke))
                .build();
        return getResponse(request);
    }

    @Override
    public Joke getJokeByCategory(String category) {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(urlByCategoryJoke + category))
                .build();
        return getResponse(request);
    }

    private Joke getResponse(HttpRequest request) {
        try {
            HttpResponse<String> response = httpClient.send(
                    request, HttpResponse.BodyHandlers.ofString());

            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return JokeDtoMapper.toJoke(objectMapper.readValue(response.body(), JokeDto.class));
        } catch (IOException | InterruptedException ex) {
            throw new JokeProviderExeption("ERROR!");
        }
    }
}
