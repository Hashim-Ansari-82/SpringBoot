package com.crud.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class ReqDto {

    @NotBlank(message = "Please Enter Name")
    private String name;
    @NotNull(message = "Age Must be enter")
    private Integer age;
    @NotBlank(message = "Please Enter gender")
    private String gender;

    @Email
    private String email;
    @Pattern(regexp = "^[6-9]\\d{9}$")
    private String mobile;
    @NotBlank(message = "Please Enter address")
    private String address;

    private String college;

    @NotBlank(message = "Please Enter course")
    private String course;

    @NotNull(message = "Please Enter percent")
    private Double percentage;
    @NotBlank(message = "Please Enter grade")
    private String grade;
    @NotBlank(message = "must enter semester")
    public String semester;

    @NotBlank(message = "Please Enter blood type")
    private String bloodGroup;
    @NotBlank(message = "must be enter")
    private String nationality;
}
