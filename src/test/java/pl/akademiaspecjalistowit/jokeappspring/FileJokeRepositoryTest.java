//package pl.akademiaspecjalistowit.jokeappspring;
//
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.util.ArrayList;
//import java.util.List;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import pl.akademiaspecjalistowit.jokeappspring.joke.model.Joke;
//import pl.akademiaspecjalistowit.jokeappspring.joke.repository.FileJokeRepository;
//
//class FileJokeRepositoryTest {
//
//    @Test
//    @Disabled
//    void shouldReadJokeFromFile() {
//        FileJokeRepository fileJokeRepository = new FileJokeRepository("src/main/resources/jokes.json");
//
//        //when
//        List<Joke> allJokes = fileJokeRepository.getAllJokes();
//
//        //then
//        Assertions.assertFalse(allJokes.isEmpty());
//    }
//
//
//    @Test
//    @Disabled
//    void createJokeFile() throws IOException {
//        Path file = Files.createFile(Path.of("src/main/resources/jokes.json"));
//
//        List<Joke> jokes = new ArrayList<>();
//        jokes.add(new Joke("category1", "content1"));
//        jokes.add(new Joke("category2", "content2"));
//        jokes.add(new Joke("category3", "content3"));
//        jokes.add(new Joke("category4", "content4"));
//        jokes.add(new Joke("category5", "content5"));
//        jokes.add(new Joke("category6", "content6"));
//        jokes.add(new Joke("category7", "content7"));
//
//        new ObjectMapper().writeValue(file.toFile(), jokes);
//    }
//
//
//}