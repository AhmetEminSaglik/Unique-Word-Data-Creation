package org.aes.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "word_1_500_000")
@NoArgsConstructor
public class WordGroup {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "pool_id")
    private int poolId;

    public WordGroup(int poolId) {
        this.poolId = poolId;
    }

    @Override
    public String toString() {
        return "WordGroup{" +
                "id=" + id +
                ", poolId=" + poolId +
                '}';
    }
}
