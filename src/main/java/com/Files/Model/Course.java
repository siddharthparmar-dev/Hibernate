package com.Files.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "CourseTable")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "Course_Seq",sequenceName = "MyCourseSeq",initialValue = 1001,allocationSize=1)
    private int id;

    @Column(name = "course_name")
    private String courseName;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    public Course() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {   // Optional, Hibernate khud set karega
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}