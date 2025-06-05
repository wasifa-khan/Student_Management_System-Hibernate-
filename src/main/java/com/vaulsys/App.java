package com.vaulsys;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Random;

public class App {
    public static void main(String[] args) {

    	Configuration config = new Configuration().configure("hibernate.cfg.xml");


        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

        try {
            // Create Departments
            Department csDept = new Department("Computer Science");
            Department mathDept = new Department("Mathematics");
            Department physicsDept = new Department("Physics");

            session.save(csDept);
            session.save(mathDept);
            session.save(physicsDept);

            // Create Courses
            Course[] courses = new Course[10];
            courses[0] = new Course("Java Programming", "3 months", csDept);
            courses[1] = new Course("Data Structures", "4 months", csDept);
            courses[2] = new Course("Algorithms", "4 months", csDept);
            courses[3] = new Course("Calculus", "5 months", mathDept);
            courses[4] = new Course("Linear Algebra", "3 months", mathDept);
            courses[5] = new Course("Quantum Physics", "6 months", physicsDept);
            courses[6] = new Course("Thermodynamics", "4 months", physicsDept);
            courses[7] = new Course("Operating Systems", "5 months", csDept);
            courses[8] = new Course("Discrete Mathematics", "3 months", mathDept);
            courses[9] = new Course("Database Systems", "4 months", csDept);

            for (Course course : courses) {
                session.save(course);
                course.getDepartment().addCourse(course);
            }

            // Create Students and Certificates, assign Courses randomly
            Random random = new Random();

            for (int i = 1; i <= 20; i++) {
                int rollNumber = 2000 + i;
                Student student = new Student(rollNumber, "Student" + i, 18 + random.nextInt(10), 
                        i % 2 == 0 ? "female" : "male", "Address " + i, "Phone" + (1000 + i));
                
                // Assign random 2 to 4 courses
                int coursesCount = 2 + random.nextInt(3);
                for (int j = 0; j < coursesCount; j++) {
                    Course course = courses[random.nextInt(courses.length)];
                    student.addCourse(course);
                }

                // Create certificate for student
                Certificate certificate = new Certificate("Certification " + i, (1 + random.nextInt(6)) + " months", student);
                student.setCertificate(certificate);

                session.save(student);
                // Certificate saved via cascade by Student
            }

            tx.commit();
            System.out.println("Inserted 20 records for Students, Certificates, Courses, and Departments successfully.");
        } catch (Exception e) {
            tx.rollback();
            System.out.println("Failed to save records: " + e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
