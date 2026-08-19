package com.crud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    private String name;
    private Integer age;
    private String gender;

    private String email;
    private String mobile;
    private String address;
    private boolean deleted;

    private String course;
    private String college;
    private String semester;

    private Double percentage;
    private String grade;

    private String bloodGroup;
    private String nationality;

}
