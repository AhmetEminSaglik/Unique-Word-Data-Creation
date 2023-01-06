package org.aes.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
//import javax.persistence.*;

@Entity
@Table(name = "words")
public class Word {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "word")
    private String word;

    public Word(String word) {
        this.word = word;
    }

    public Word() {
    }

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", word='" + word + '\'' +
                '}';
    }
}
