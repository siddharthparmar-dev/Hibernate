package com.Files.App;

import com.Files.Model.Laptop;
import com.Files.Model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneMapping {
    static void main(String[] args) {
        Configuration cfg = null;
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        boolean flag = false;

        try{
            cfg = new Configuration();
            cfg.addAnnotatedClass(Laptop.class);
            cfg.addAnnotatedClass(Student.class);
            sf = cfg.buildSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();

            Laptop laptop = new Laptop();
            laptop.setBrand("HP");

            Student student = new Student();
            student.setName("Siddharth");
            student.setCity("Delhi");

            //student.setLaptop(laptop);

            session.persist(laptop);
            session.persist(student);

            flag = true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{
            if (flag) {
                tx.commit();
                session.close();
                sf.close();
            }
            else {
                tx.rollback();
            }
        }
    }
}
