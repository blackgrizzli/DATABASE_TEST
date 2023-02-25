package org.example;

import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HQL {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        try (Session session = sf.openSession()) {
            Query<Cat> selectNameCatFromCat = session.createQuery("from Cat where id < 100", Cat.class);
            List<Cat> list = selectNameCatFromCat.list();
            list.forEach(System.out::println);
            ScrollableResults<Cat> scroll = selectNameCatFromCat.scroll();
            scroll.scroll(3);
            Cat cat = scroll.get();
            System.out.println(cat);
        }
    }
}
