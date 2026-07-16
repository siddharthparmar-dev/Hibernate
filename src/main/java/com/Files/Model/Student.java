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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "college_id")
    private College college;

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