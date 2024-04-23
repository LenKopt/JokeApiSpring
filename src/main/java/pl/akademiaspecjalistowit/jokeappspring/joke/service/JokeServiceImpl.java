package pl.akademiaspecjalistowit.jokeappspring.joke.service;

import java.util.List;

import org.springframework.stereotype.Service;
import pl.akademiaspecjalistowit.jokeappspring.joke.model.Joke;
import pl.akademiaspecjalistowit.jokeappspring.joke.service.provider.JokeProvider;

@Service
public class JokeServiceImpl implements JokeService {

    private final List<JokeProvider> jokeProviders;
    private static long counter = 0;

    public JokeServiceImpl(List<JokeProvider> jokeProviders) {
        if (jokeProviders == null || jokeProviders.isEmpty()) {
            throw new JokeServiceExeption("Required at least one JokeProvider for the application to run");
        }
        this.jokeProviders = jokeProviders;
    }

    @Override
    public Joke getJoke() {
        return getJokeProvider().getJoke();
    }

    @Override
    public Joke getJoke(String category) {
        return getJokeProvider().getJokeByCategory(category);
    }

    private JokeProvider getJokeProvider() {
        return jokeProviders.get((int) counter++ % jokeProviders.size());
    }
}
