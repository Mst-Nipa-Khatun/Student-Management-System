package com.StudentManagement.controller;

import com.StudentManagement.Dto.Response;
import com.StudentManagement.Dto.StudentDto;
import com.StudentManagement.service.StudentService;
import com.StudentManagement.utils.UrlConstraint;
import lombok.Builder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UrlConstraint.StudentManagement.ROOT)
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(UrlConstraint.StudentManagement.CREATE)
    public Response createStudent(@RequestBody StudentDto studentDto) {
        return studentService.createStudent(studentDto);
    }

}
