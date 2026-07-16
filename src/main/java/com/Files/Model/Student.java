package com.Files.Model;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "StudentTable")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "my_Seq",
            sequenceName = "My_OwnSequence",
            initialValue = 100,
            allocationSize = 1
    )
    private int id;

    private String name;

    private String city;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Student() {
    }

    // getters setters
}
//    public College getCollege() {
//        return college;
//    }
//
//    public void setCollege(College college) {
//        this.college = college;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "College_ID")
//    private College college;

//    @OneToOne
//    private Laptop laptop;
//
//    public Laptop getLaptop() {
//        return laptop;
//    }
//
//    public void setLaptop(Laptop laptop) {
//        this.laptop = laptop;
//    }