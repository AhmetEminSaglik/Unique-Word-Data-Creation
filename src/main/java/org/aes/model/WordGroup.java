package org.aes.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "word_50")
@NoArgsConstructor
public class WordGroup {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //    @Column(name = "pool_id")
//    private int poolId;
    @Column(name = "word")
    private String word;

    public WordGroup(String word) {
        this.word = word;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return "WordGroup{" +
                "id=" + id +
                ", word='" + word + '\'' +
                '}';
    }

}
