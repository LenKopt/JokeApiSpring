package pl.akademiaspecjalistowit.jokeappspring.joke.mapper;

import org.springframework.stereotype.Component;
import pl.akademiaspecjalistowit.jokeappspring.joke.entity.JokeEntity;
import pl.akademiaspecjalistowit.jokeappspring.joke.model.Joke;
@Component
public class JokeMapper {
    public Joke fromEntity(JokeEntity jokeEntity){
        return new Joke(jokeEntity.getTech_id(),jokeEntity.getContent(),jokeEntity.getCategory());
    }
}
