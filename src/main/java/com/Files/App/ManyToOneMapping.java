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
