package org.example.oneToMany_ColumJoin;

import jakarta.persistence.*;

@Entity
@Table(name = "elephant")
public class Elephant {
    @Id
    @GeneratedValue
    private int id;

    public Elephant(String name, int weight, int size) {
        this.name = name;
        this.weight = weight;
        this.size = size;
    }

    @Column(name = "elephant_name")
    private String name;
    @Column(name = "elephant_weight_kg")
    private int weight;
    @Column(name = "elephant_size")
    private int size;
    @ManyToOne()
    private Zoo zoo;

    public Elephant() {

    }
}
