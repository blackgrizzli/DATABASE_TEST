package org.example.manyToOne_ColumJoin;

import org.example.Cat;
import org.example.CreateTimestamp_UpdateTimestam.Imploee;
import org.example.Dog;
import org.example.Main;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


import java.util.Date;
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

        Employee employee = new Employee("Andrey",30000,new Date());
        EmployeeTask employeeTask = new EmployeeTask("Исправить код",employee,new Date());
//        solution.addCat(employee);
//        solution.addCat(employeeTask);

        try(Session session = solution.sf.openSession()){

            Query<Employee> query = session.createQuery(" select employee from EmployeeTask where name = 'Написать код' ", Employee.class);
            List<Employee> list = query.list();
            list.forEach(System.out::println);
        }
    }
}
