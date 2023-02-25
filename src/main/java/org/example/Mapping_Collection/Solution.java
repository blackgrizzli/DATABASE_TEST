package org.example.Mapping_Collection;

import org.example.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

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
    public void createTable() throws ClassNotFoundException, SQLException {
        String userName = "root";
        String password = "12wq12wQ";
        String url = "jdbc:mysql://localhost:3306";
        Class.forName("com.mysql.jdbc.Driver");

        try(Connection connection = DriverManager.getConnection(url,userName,password)){
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE Person.user_message (user_id INT,index_id INT,message VARCHAR(255))");
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Solution solution = new Solution();
        //solution.createTable();
        Map<String,Integer> map = new HashMap<>();
        map.put("Vova", 30);
        map.put("Petia", 5);

        MappingCollection mappingCollection = new MappingCollection(map);
        mappingCollection.id = 1;

        solution.addClass(mappingCollection);
    }
}
