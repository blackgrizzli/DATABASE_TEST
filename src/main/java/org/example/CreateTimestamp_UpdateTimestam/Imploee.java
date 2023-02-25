package org.example.CreateTimestamp_UpdateTimestam;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Imploee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int Id;
    private String name;
    private String job;

    @Column(name="created_time")
    public Date created;

    @Column(name="updated_time")
    public Date updated;

    public Imploee() {
    }
    @PrePersist
    public void onCreate() {
        created = new Date();
        System.out.println("метод onCreate вызвался");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @PreUpdate
    public void onUpdate() {
        updated = new Date();
        System.out.println("метод onUpdate вызвался");
    }
    public Imploee(String name, String job) {
        this.name = name;
        this.job = job;
    }
}
