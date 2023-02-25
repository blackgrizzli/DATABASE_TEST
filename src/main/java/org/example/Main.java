package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    private SessionFactory sf;

    public Main() {
        this.sf = new Configuration().configure().buildSessionFactory();
    }

    public List<Cat> getAllCat() {
        try (Session session = sf.openSession()) {
            Query<Cat> query = session.createQuery("from Cat", Cat.class);
            return query.list();
        }
    }

    public void addCat(Cat cat) {
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(cat);
            transaction.commit();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Cat cat = new Cat("Васька", 13);
        Main main = new Main();
        main.addCat(cat);

        List<Cat> allCat = main.getAllCat();
        allCat.forEach(System.out::println);
    }
}
