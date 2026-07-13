package com.Files.App;

import com.Files.Model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Delete {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Student student = session.getReference(Student.class,5);
            if (student != null) {
                session.remove(student);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            transaction.commit();
            session.close();
            sessionFactory.close();
        }

    }
}
