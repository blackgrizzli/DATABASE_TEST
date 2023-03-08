package org.example;

import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HQL {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        try (Session session = sf.openSession()) {
//            Query<Cat> selectNameCatFromCat = session.createNamedQuery("findAllUser", Cat.class);
//            List<Cat> list = selectNameCatFromCat.list();
//            list.forEach(System.out::println);
//
//            Query<Cat> findFirstUser = session.createNamedQuery("findFirstUser", Cat.class);
//            findFirstUser.setParameter("name", "tom");
//            List<Cat> list1 = findFirstUser.list();
//            list1.forEach(System.out::println);
            Cat cat = new Cat("НовыйКот",111);
            Transaction transaction = session.beginTransaction();
            session.persist(cat);
            session.flush();
            Query<Cat> selectNameCatFromCat = session.createQuery("from Cat where id < 100", Cat.class);
            List<Cat> list = selectNameCatFromCat.list();
            list.forEach(System.out::println);
            ScrollableResults<Cat> scroll = selectNameCatFromCat.scroll();
            scroll.scroll(3);
            Cat cat1 = scroll.get();
            System.out.println(cat);
        }
    }
}
