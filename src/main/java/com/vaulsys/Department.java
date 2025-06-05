package com.vaulsys;

import javax.persistence.*;   

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Department_Name")
    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private Set<Course> courses = new HashSet<>();

    public Department() {}

    public Department(String name) {
        this.name = name;
    }

    // Getters and setters

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Set<Course> getCourses() { return courses; }
    public void addCourse(Course course) {
        courses.add(course);
        course.setDepartment(this);
    }
}
