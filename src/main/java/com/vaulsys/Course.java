package com.vaulsys;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Course_Name")
    private String name;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>();

    public Course() {}

    public Course(String name) {
        this.name = name;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudents() {
        return students;
    }
}
