package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Cat {
    public Cat() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCat() {
        return nameCat;
    }

    public void setNameCat(String nameCat) {
        this.nameCat = nameCat;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Cat( String nameCat, int age) {
        this.nameCat = nameCat;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", nameCat='" + nameCat + '\'' +
                ", age=" + age +
                '}';
    }

    @Id
    @GeneratedValue
    public int id;
    public String nameCat;
    public int age;
}


