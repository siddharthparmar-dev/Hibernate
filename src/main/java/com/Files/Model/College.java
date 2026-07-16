package com.Files.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "CollegeTable")
public class College {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "college_seq_gen",
            sequenceName = "college_sequence",
            initialValue = 1001,
            allocationSize = 1
    )
    private int id;

    private String name;

    public College() {
    }

    // getters setters

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
}