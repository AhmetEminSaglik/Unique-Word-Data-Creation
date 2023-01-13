package org.aes.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "word_3_000_000")
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

    @Override
    public String toString() {
        return "WordGroup{" +
                "id=" + id +
                ", word='" + word + '\'' +
                '}';
    }
}
