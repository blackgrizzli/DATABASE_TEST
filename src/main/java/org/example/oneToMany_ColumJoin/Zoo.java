package org.example.oneToMany_ColumJoin;

import jakarta.persistence.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "zoo")
public class Zoo {
    @Id
    @GeneratedValue
    private int id;

    public Zoo(String zooName, int sizeOfAnimal, List<Elephant> list) {
        this.zooName = zooName;
        this.sizeOfAnimal = sizeOfAnimal;
        this.list = list;
    }

    @Column(name = "zoo_name")
    private String zooName;
    @Column(name = "size_animal")
    private int sizeOfAnimal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zoo")
    @LazyCollection(LazyCollectionOption.EXTRA)
    @OrderColumn(name = "order_id")
    private List<Elephant> list = new ArrayList<>();

    public Zoo() {

    }
}
