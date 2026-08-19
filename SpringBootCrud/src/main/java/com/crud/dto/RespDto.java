package com.crud.dto;

import lombok.Data;

@Data
public class RespDto {

    private Integer id ;

    private String name;
    private Integer age;
    private String gender;
    private boolean deleted;

    private String course;
    private String college;
    private String address;
    private String semester;

    private String mobile;
    private Double percentage;
    private String grade;

    private String bloodGroup;
    private String nationality;
}
