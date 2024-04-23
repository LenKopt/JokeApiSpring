package pl.akademiaspecjalistowit.jokeappspring.joke.service.provider;

import pl.akademiaspecjalistowit.jokeappspring.joke.service.JokeServiceExeption;

public class JokeProviderExeption extends JokeServiceExeption {
    public JokeProviderExeption(String message) {
        super(message);
    }
}
