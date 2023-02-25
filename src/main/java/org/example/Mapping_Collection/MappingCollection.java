package org.example.Mapping_Collection;

import jakarta.persistence.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Entity

public class MappingCollection {


    @Id
    public Integer id;

    public MappingCollection(Map<String, Integer> map) {
        this.map = map;
    }

    @ElementCollection
   @CollectionTable(name="user_message",joinColumns = @JoinColumn(name = "user_id"))
//    @Column(name = "message")
    public Map<String , Integer> map;
    public MappingCollection() {

    }
}
