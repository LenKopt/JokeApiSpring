package pl.akademiaspecjalistowit.jokeappspring.joke.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.akademiaspecjalistowit.jokeappspring.joke.entity.JokeEntity;
import pl.akademiaspecjalistowit.jokeappspring.joke.model.Joke;

import java.util.List;

@Repository
public interface JokeEntityRepository extends JpaRepository<JokeEntity, Long>{
    List<JokeEntity> findAll();

    List<JokeEntity> findAllByCategory(String category);
}
