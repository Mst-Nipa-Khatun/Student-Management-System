package com.StudentManagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="student_management")
public class StudentEntity extends BaseEntity {
    private String name;
    private Integer age;
    private String gender;
}
