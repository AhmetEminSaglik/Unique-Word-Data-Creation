package org.aes.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "word_pool")
@NoArgsConstructor
public class WordPool {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "word")
    private String word;

    public WordPool(String word) {
        this.word = word;
    }

     @Override
    public String toString() {
        return "WordPool{" +
                "id=" + id +
                ", word='" + word + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }
//
    public String getWord() {
        return word;
    }
//
//    public void setWord(String word) {
//        this.word = word;
//    }
}
