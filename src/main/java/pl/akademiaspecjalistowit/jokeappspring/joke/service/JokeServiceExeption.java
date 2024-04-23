package pl.akademiaspecjalistowit.jokeappspring.joke.service;

public class JokeServiceExeption extends RuntimeException{
    public JokeServiceExeption(String message) {
        super(message);
    }
}
