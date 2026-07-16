package com.Files.App;

import com.Files.Model.College;
import com.Files.Model.Laptop;
import com.Files.Model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToOneMapping {
    static void main(String[] args) {
        Configuration cfg = null;
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        boolean flag = false;

        try{
            cfg = new Configuration();
            cfg.addAnnotatedClass(College.class);
            cfg.addAnnotatedClass(Student.class);
            sf = cfg.buildSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();

            College c = new College();
            c.setName("DTU");

            Student s1 = new Student();
            s1.setName("John");
            s1.setCollege(c);

            Student s2 = new Student();
            s2.setName("Rahul");
            s2.setCollege(c);

            Student s3 = new Student();
            s3.setName("Aman");
            s3.setCollege(c);


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(flag){
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
