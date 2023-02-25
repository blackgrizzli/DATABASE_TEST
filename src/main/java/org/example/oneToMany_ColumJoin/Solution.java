package org.example.oneToMany_ColumJoin;

import org.example.Cat;
import org.example.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private SessionFactory sf;

    public Solution() {
        this.sf = new Configuration().configure().buildSessionFactory();
    }

    public void setQuery(String query) {
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createNativeQuery(query, Dog.class).executeUpdate();
            transaction.commit();
        }
    }

    public List<Cat> getAllCat() {
        try (Session session = sf.openSession()) {
            Query<Cat> query = session.createQuery("from Cat", Cat.class);
            return query.list();
        }
    }

    public <T> void addCat(T clazz) {
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(clazz);
            transaction.commit();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        

        Elephant elephant1 = new Elephant("Slon_1", 254, 3);
        Elephant elephant2 = new Elephant("Slon_2", 300, 2);
        Elephant elephant3 = new Elephant("Slon_3", 100, 5);
        List<Elephant> list = new ArrayList<>();
        list.add(elephant1);
        list.add(elephant2);
        list.add(elephant3);

        Zoo zoo = new Zoo("Elephant_zoo", 200, list);
        solution.addCat(zoo);
        solution.addCat(elephant1);
        solution.addCat(elephant2);
        solution.addCat(elephant3);
    }
}
