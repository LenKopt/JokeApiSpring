package pl.akademiaspecjalistowit.jokeappspring.joke.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import pl.akademiaspecjalistowit.jokeappspring.joke.model.Joke;

@Repository
public class FileJokeRepository implements JokeRepository {

    private final Map<String, List<Joke>> jokesWithCategories;

    public FileJokeRepository(@Value("${jokes.files.pathToJokeFile}") String pathToJokesFile) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            jokesWithCategories =
                    objectMapper.readValue(Paths.get(pathToJokesFile).toFile(), new TypeReference<List<Joke>>() {
                            })
                            .stream().collect(Collectors.groupingBy(Joke::getCategory));

        } catch (IOException e) {
            throw new RuntimeException("cannot deserialize Jokes from file", e);
        }
    }

    @Override
    public List<Joke> getAllJokes() {
        return jokesWithCategories.entrySet()
                .stream()
                .flatMap(e -> e.getValue().stream())
                .collect(Collectors.toList());
    }

    @Override
    public List<Joke> getAllByCategory(String category) {
        return jokesWithCategories.get(category);
    }

    private static Predicate<Joke> compareCategories(String category) {
        return c -> c.getCategory().equals(category);
    }
}
