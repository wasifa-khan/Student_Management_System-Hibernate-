package com.vaulsys;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {

        Department d1 = new Department("Computer Science");

        Course c1 = new Course("Java Programming");
        Course c2 = new Course("Web Development");

        Student s1 = new Student(2001, "Wasifa", 22, "female", "xyz", "42672892");
        Student s2 = new Student(2002, "Ali", 25, "male", "abc", "12345678");

        s1.setDepartment(d1);
        s2.setDepartment(d1);

        s1.addCourse(c1);
        s1.addCourse(c2);

        s2.addCourse(c2);

        Certificate cert1 = new Certificate("Java Programming", "3 months", s1);
        s1.setCertificate(cert1);

        Certificate cert2 = new Certificate("Web Development", "6 months", s2);
        s2.setCertificate(cert2);

        Configuration config = new Configuration().configure("hibernate.cfg.xml");
        config.addAnnotatedClass(Student.class);
        config.addAnnotatedClass(Certificate.class);
        config.addAnnotatedClass(Department.class);
        config.addAnnotatedClass(Course.class);

        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();
        try {
            session.save(d1);
            session.save(c1);
            session.save(c2);
            session.save(s1);
            session.save(s2);
            tx.commit();
            System.out.println("All records saved successfully");
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
