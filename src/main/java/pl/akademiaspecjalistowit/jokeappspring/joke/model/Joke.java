package pl.akademiaspecjalistowit.jokeappspring.joke.model;

import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;
@AllArgsConstructor
public class Joke implements Serializable {

    private UUID id;
    private String content;
    private String category;

    public Joke(String category, String content) {
        this.id = UUID.randomUUID();
        this.content = content;
        this.category = category;
    }

    private Joke(){
        this.id = UUID.randomUUID();
    }

    public String getCategory() {
        return category;
    }

    public String getContent() {
        return content;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Joke joke = (Joke) o;
        return Objects.equals(content, joke.content) && Objects.equals(category, joke.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, category);
    }
}