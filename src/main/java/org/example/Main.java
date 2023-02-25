package org.example;


import org.apache.log4j.PropertyConfigurator;
import org.example.CreateTimestamp_UpdateTimestam.Imploee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Main {
    public static final Logger logger = LoggerFactory.getLogger(Main.class);
    private SessionFactory sf;

    public Main() {
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
        logger.debug("Зашли в метод");
        try (Session session = sf.openSession()) {
            Query<Cat> query = session.createQuery("from Cat", Cat.class);
            logger.debug("Конец метода");
            return query.list();
        }
    }

    public <T> void addCat(T clazz) {
        logger.info("Зашли в метод запись БД");
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(clazz);
            transaction.commit();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Imploee imploee = new Imploee("Bob", "programmer");
        Imploee imploee1 = new Imploee("Dima", "Fly");
        Imploee imploee2 = new Imploee("Andrey", "notWork");
        Main main = new Main();
//        main.addCat(imploee);
//        main.addCat(imploee1);
//        main.addCat(imploee2);

//        try (Session session = main.sf.openSession()) {
//            Transaction transaction = session.beginTransaction();
//            Imploee imploee3 = session.get(Imploee.class, 1);
//            imploee3.setJob("coolJob!");
//            session.persist(imploee3); // выполнит update
//            transaction.commit();
//        }
//        try (Session session = main.sf.openSession()) {
//            Transaction transaction = session.beginTransaction();
//            session.createQuery("update Imploee set job = 'home' where Id = 2").executeUpdate();
//            transaction.commit();
//        }
    }
}

