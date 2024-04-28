package pl.akademiaspecjalistowit.jokeappspring.joke.controller;

import org.springframework.web.bind.annotation.*;
import pl.akademiaspecjalistowit.jokeappspring.joke.entity.JokeEntity;
import pl.akademiaspecjalistowit.jokeappspring.joke.model.Joke;
import pl.akademiaspecjalistowit.jokeappspring.joke.service.JokeService;
import pl.akademiaspecjalistowit.jokeappspring.joke.repository.JokeEntityRepository;

import java.awt.print.Book;

@RestController
@RequestMapping("/jokes")
public class JokeController {
    private JokeService jokeService;
    private final JokeEntityRepository jokeEntityRepository;

    public JokeController(JokeService jokeService, JokeEntityRepository jokeEntityRepository) {

        this.jokeService = jokeService;
        this.jokeEntityRepository = jokeEntityRepository;
    }

    @GetMapping("/joke")
    public Joke getAnyJoke(@RequestParam(name = "category", required = false) String category) {
        if (category != null) {
            return jokeService.getJoke(category);
        }
        return jokeService.getJoke();
    }

//    @PostMapping("/addBook")
//    public Joke addBook(@RequestBody Joke joke) {
//        System.out.println(joke.getId());
//        System.out.println(joke);
//        return null;
//    }
//
//    @PostMapping
//    public void saveJoke(@RequestBody Joke joke) {
//        System.out.println(joke);
//    }

    @PostMapping
    public void addJoke(@RequestBody Joke joke){
        JokeEntity jokeEntity = new JokeEntity(joke.getId(), joke.getContent(), joke.getCategory());
        jokeEntityRepository.save(jokeEntity);
    }
}
