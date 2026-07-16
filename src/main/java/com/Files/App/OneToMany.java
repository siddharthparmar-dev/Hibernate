package com.Files.App;

import com.Files.Model.Course;
import com.Files.Model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

public class OneToMany {
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

            Course c1 =  new Course();
            c1.setCourseName("Java");
            Course c2 =  new Course();
            c2.setCourseName("JavaScript");
            Course c3 =  new Course();
            c3.setCourseName("Python");
            ArrayList<Course> courses = new ArrayList<Course>();
            courses.add(c1);
            courses.add(c2);
            courses.add(c3);
            Student s1 = new Student();
            s1.setName("John");
            s1.setCity("San Francisco");
            s1.setCourses(courses);
            session.persist(s1);
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
