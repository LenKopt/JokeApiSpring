package pl.akademiaspecjalistowit.jokeappspring.joke.service.provider;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;
import pl.akademiaspecjalistowit.jokeappspring.joke.model.Joke;
import pl.akademiaspecjalistowit.jokeappspring.joke.repository.JokeRepository;

@Service
public class JokeDataProvider implements JokeProvider {

    private final List<JokeRepository> jokeRepositories;
    private static long counter = 0;
    private final Random rand;

    public JokeDataProvider(List<JokeRepository> jokeRepositories, Random random) {

        this.jokeRepositories = jokeRepositories;
        this.rand = random;
    }

    @Override
    public Joke getJoke() {
        List<Joke> anyJokes = getJokeRepository().getAllJokes();
        return anyJokes.get(rand.nextInt(anyJokes.size()));
    }

    @Override
    public Joke getJokeByCategory(String category) {
        List<Joke> jokesByCategory =
                getJokeRepository().getAllByCategory(category);
        try {
            return jokesByCategory.get(rand.nextInt(jokesByCategory.size()));
        } catch (JokeProviderExeption e) {
            throw new JokeProviderExeption("Joke from category " + category + " was not found");
        }
    }

    private JokeRepository getJokeRepository() {
        return jokeRepositories.get((int) counter++ % jokeRepositories.size());
    }
}