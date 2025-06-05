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

    @Column(name = "Dept_Name")
    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private Set<Student> students = new HashSet<>();

    public Department() {}

    public Department(String name) {
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

    public void addStudent(Student student) {
        students.add(student);
        student.setDepartment(this);
    }
}
