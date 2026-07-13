package com.Files.App;

import com.Files.Model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Update {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = null;
        Transaction transaction = null;
        boolean flag = false;

        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Student student = session.get(Student.class, 5);
            student.setName("Shivam");
            student.setCity("Dehradun");

            session.persist(student);
            flag = true;
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (flag) {
                transaction.commit();
                session.close();
            }
            else  {
                transaction.rollback();
            }
        }
    }
}
