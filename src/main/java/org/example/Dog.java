package org.example;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.Type;


import java.time.LocalDate;
import java.util.Date;

@Entity
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    private int age;

    private LocalDate localDate;


    private boolean isYes;

    public Dog() {

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getDate() {
        return localDate;
    }

    public void setDate(LocalDate localDate) {
        this.localDate = localDate;
    }


    public boolean isYes() {
        return isYes;
    }

    public void setYes(boolean yes) {
        isYes = yes;
    }

    public Dog(int age, LocalDate localDate, boolean isYes) {
        this.age = age;
        this.localDate = localDate;
       // this.list = list;
        this.isYes = isYes;
    }
}
