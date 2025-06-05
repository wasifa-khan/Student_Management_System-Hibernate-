package com.vaulsys;

import javax.persistence.*;   


@Entity
@Table(name = "Certificate")
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Course_Name")
    private String courseName;

    @Column(name = "Duration")
    private String duration;

    @OneToOne
    @JoinColumn(name = "student_roll_number", unique = true)
    private Student student;

    public Certificate() {}

    public Certificate(String courseName, String duration, Student student) {
        this.courseName = courseName;
        this.duration = duration;
        this.student = student;
    }

    // Getters and setters

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
}
