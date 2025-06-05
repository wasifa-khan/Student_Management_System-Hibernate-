package com.vaulsys;

import javax.persistence.*;   

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Student")
public class Student {

    @Id
    @Column(name = "Roll_number")
    private int rollNumber;

    @Column(name = "Name")
    private String name;

    @Column(name = "Age")
    private int age;

    @Column(name = "Gender")
    private String gender;

    @Column(name = "Address")
    private String address;

    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Certificate certificate;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
        name = "Student_Course",
        joinColumns = @JoinColumn(name = "student_roll_number"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses = new HashSet<>();

    public Student() {}

    public Student(int rollNumber, String name, int age, String gender, String address, String phoneNumber) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    // Getters and setters

    public int getRollNumber() { return rollNumber; }
    public void setRollNumber(int rollNumber) { this.rollNumber = rollNumber; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public Certificate getCertificate() { return certificate; }
    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
        if (certificate != null) {
            certificate.setStudent(this);
        }
    }

    public Set<Course> getCourses() { return courses; }
    public void addCourse(Course course) {
        courses.add(course);
        course.getStudents().add(this);
    }
    public void removeCourse(Course course) {
        courses.remove(course);
        course.getStudents().remove(this);
    }
}
