package com.StudentManagement.Dto;

import lombok.Data;

@Data
public class StudentDto extends BaseDto {
    private String name;
    private String age;
    private String gender;
}
