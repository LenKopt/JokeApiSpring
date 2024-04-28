package pl.akademiaspecjalistowit.jokeappspring.joke.service.provider;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import pl.akademiaspecjalistowit.jokeappspring.joke.entity.JokeEntity;
import pl.akademiaspecjalistowit.jokeappspring.joke.mapper.JokeMapper;
import pl.akademiaspecjalistowit.jokeappspring.joke.model.Joke;
import pl.akademiaspecjalistowit.jokeappspring.joke.repository.JokeEntityRepository;
import pl.akademiaspecjalistowit.jokeappspring.joke.repository.JokeRepository;

@Service
public class JokeDataProvider implements JokeProvider {

    private final List<JokeRepository> jokeRepositories;
    private final JokeEntityRepository jokeEntityRepository;
    private final JokeMapper jokeMapper;
    private static long counter = 0;
    private final Random rand;

    public JokeDataProvider(List<JokeRepository> jokeRepositories, Random random, JokeEntityRepository jokeEntityRepository, JokeMapper jokeMapper) {

        this.jokeRepositories = jokeRepositories;
        this.rand = random;
        this.jokeEntityRepository = jokeEntityRepository;
        this.jokeMapper = jokeMapper;
    }

    @Override
    public Joke getJoke() {
        //List<Joke> anyJokes = getJokeRepository().getAllJokes();
        List<JokeEntity> listJokes = jokeEntityRepository.findAll();
        //JokeEntity jokeEntity = jokeEntityRepository.findOne(example);
        //return anyJokes.get(rand.nextInt(anyJokes.size()));
        JokeEntity anyJokeEntity = listJokes.get(rand.nextInt(listJokes.size()));
        return jokeMapper.fromEntity(anyJokeEntity);
    }

    @Override
    public Joke getJokeByCategory(String category) {
        //List<Joke> jokesByCategory =
        //        getJokeRepository().getAllByCategory(category);
        try {
            //return jokesByCategory.get(rand.nextInt(jokesByCategory.size()));
            List<JokeEntity> listJokes = jokeEntityRepository.findAllByCategory(category);
            JokeEntity anyJokeEntity = listJokes.get(rand.nextInt(listJokes.size()));
            return jokeMapper.fromEntity(anyJokeEntity);
        } catch (JokeProviderExeption e) {
            throw new JokeProviderExeption("Joke from category " + category + " was not found");
        }
    }

    private JokeRepository getJokeRepository() {
        return jokeRepositories.get((int) counter++ % jokeRepositories.size());
    }
}