package com.Files.App;

import com.Files.Model.Employee;
import com.Files.Model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SetProperty {
    public static void main(String[] args) {
        Configuration configuration = null;
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        boolean flag = false;

        configuration = new Configuration();

        configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        configuration.setProperty("hibernate.connection.username", "root");
        configuration.setProperty("hibernate.connection.password", "S!dd#@rt#");
        configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/studentdb");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.format_sql", "true");
        configuration.setProperty("hibernate.highlight_sql", "true");

        configuration.addAnnotatedClass(Employee.class);
        sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            Employee employee = new Employee();
            employee.setEid(1);
            employee.setEname("Siddharth");
            employee.setEage(22);
            employee.setEcity("Delhi");
            session.persist(employee);
            flag = true;
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (flag) {
            transaction.commit();
            session.close();
            sessionFactory.close();
            }
        }

    }
}
