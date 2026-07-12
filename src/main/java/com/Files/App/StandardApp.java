package com.Files.App;

import com.Files.Model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StandardApp {
    public static void main(String[] args) {
        Configuration configuration = null;
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        boolean flag = false;

        configuration = new Configuration();
        configuration.configure();

        sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();

        Student student = new Student();
        student.setId(4);
        student.setName("Karan");
        student.setCity("Ahemdabad");

        try {
            transaction = session.beginTransaction();
            session.persist(student);
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
            }else  {
                transaction.rollback();
            }
            session.close();
            sessionFactory.close();
        }
    }
}
