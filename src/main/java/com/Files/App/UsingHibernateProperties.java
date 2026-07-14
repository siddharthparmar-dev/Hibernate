package com.Files.App;

import com.Files.Model.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UsingHibernateProperties {
    public static void main(String[] args) {
        Configuration configuration = null;
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        boolean flag = false;

        configuration = new Configuration();

        configuration.addAnnotatedClass(Employee.class);
        sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            Employee employee = new Employee();
            employee.setEid(2);
            employee.setEname("Rahul");
            employee.setEage(29);
            employee.setEcity("Dehradun");
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
