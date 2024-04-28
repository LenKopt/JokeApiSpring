package pl.akademiaspecjalistowit.jokeappspring.joke.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class JokeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private UUID tech_id;
    private String content;
    private String category;

    public JokeEntity(UUID tech_id, String content, String category) {
        this.tech_id = tech_id;
        this.content = content;
        this.category = category;
    }
}
