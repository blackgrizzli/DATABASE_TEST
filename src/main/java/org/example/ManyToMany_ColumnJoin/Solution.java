package org.example.ManyToMany_ColumnJoin;

import org.example.Cat;
import org.example.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

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

    public <T> void addCat(T clazz) {
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(clazz);
            transaction.commit();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

    }
}
