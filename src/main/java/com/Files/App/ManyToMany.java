package com.Files.App;

import com.Files.Model.Course;
import com.Files.Model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class ManyToMany {
    public  static void main(String[] args) {
        Configuration cfg = null;
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        boolean flag = false;

        try{
            cfg = new Configuration();
            cfg.addAnnotatedClass(Student.class);
            cfg.addAnnotatedClass(Course.class);
            sf = cfg.buildSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            Course java = new Course();
            java.setCourseName("Java");

            Course python = new Course();
            python.setCourseName("Python");

            Student s1 = new Student();
            s1.setName("John");
            s1.setCity("San Francisco");

            Student s2 = new Student();
            s2.setName("Jane");
            s2.setCity("New York");

// John -> Java + Python
            s1.setCourses(List.of(java, python));

// Jane -> Java
            s2.setCourses(List.of(java));

            session.persist(s1);
            session.persist(s2);

            tx.commit();
            flag = true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
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
