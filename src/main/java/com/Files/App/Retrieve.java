package com.Files.App;

import com.Files.Model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Retrieve {
    static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = null;
        Transaction transaction = null;

        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        Employee employee = session.get(Employee.class, 5);
        System.out.println(employee);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
