package org.example.JdbcTypeCode_JSON;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private SessionFactory sf;

    public Solution() {
        this.sf = new Configuration().configure().buildSessionFactory();
    }

    public <T> void addClass(T clazz) {
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(clazz);
            transaction.commit();
        }
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("key1", 1);
        map.put("key2", 2);
        map.put("key3", 3);
        UserMapJson userMapJson = new UserMapJson("KeyAndValue", map);
        Solution solution = new Solution();
        solution.addClass(userMapJson);
    }
}
