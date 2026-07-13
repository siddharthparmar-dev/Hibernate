package com.Files.App;

import com.Files.Model.Employee;
import com.Files.Model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateTransient {
    static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = null;
        Transaction transaction = null;
        boolean flag = false;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Employee  employee = new Employee();
            employee.setEid(5);
            employee.setEname("John");
            employee.setEcity("San Francisco");
            employee.setEage(25);
            employee.setEaddress("d-25");
            session.persist(employee);
            flag = true;
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
          else  {
              transaction.rollback();
          }

        }
    }
}
