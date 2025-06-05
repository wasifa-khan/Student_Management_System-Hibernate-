package com.vaulsys;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	 Student stu1 = new Student(2001, "Wasifa", 22, "female", "xyz", "42672892");
         Student stu2 = new Student(2002, "Ali", 25, "male", "abc", "12345678");
         Student stu3 = new Student(2003, "Sara", 20, "female", "pqr", "98765432");

         Configuration config = new Configuration().configure("hibernate.cfg.xml");
         SessionFactory factory = config.buildSessionFactory();
         Session session = factory.openSession();

         Transaction tx = session.beginTransaction();
         try {
             session.save(stu1);
             session.save(stu2);
             session.save(stu3);
             tx.commit();
             System.out.println("All records saved successfully");
         } catch (Exception e) {
             tx.rollback();
             System.out.println("Failed to save records: " + e.getMessage());
             e.printStackTrace();
         } finally {
             session.close();
         }
    }
}
