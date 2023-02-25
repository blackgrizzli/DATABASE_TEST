package org.example;


import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Main {
    public static final Logger logger = LoggerFactory.getLogger(Main.class);
    private SessionFactory sf;

    public Main() {
        this.sf = new Configuration().configure().buildSessionFactory();
        //PropertyConfigurator.configure("src/main/resources/log4j.properties");
    }

    public List<Cat> getAllCat() {
        logger.debug("Зашли в метод");
        try (Session session = sf.openSession()) {
            Query<Cat> query = session.createQuery("from Cat", Cat.class);
            logger.debug("Конец метода");
            return query.list();
        }
    }

    public void addCat(Cat cat) {
        logger.info("Зашли в метод запись БД");
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
