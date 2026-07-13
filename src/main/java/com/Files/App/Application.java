package com.Files.App;


import com.Files.Model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Application {
    public static void main(String[] args)
    {
        //step 01 Configuration Object

        Configuration config = new Configuration();

        //configure hibernate.cfg.xml file to configuration object
        config.configure("hibernate.cfg.xml");

        //create session factory object
        SessionFactory factory = config.buildSessionFactory();

        //get the session object
        Session session = factory.openSession();

        //Begin the transaction with session
        Transaction tx = session.beginTransaction();

        Student student = new Student();
        student.setId(1);
        student.setName("Aman");
        student.setCity("Delhi");

        // perform operation
        session.persist(student);

        //perform transaction operation
        tx.commit();

        //close the session
        session.close();
    }
}