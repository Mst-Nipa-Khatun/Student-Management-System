package com.StudentManagement.controller;

import com.StudentManagement.Dto.Response;
import com.StudentManagement.Dto.StudentDto;
import com.StudentManagement.service.StudentService;
import com.StudentManagement.utils.UrlConstraint;
import lombok.Builder;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping(UrlConstraint.StudentManagement.GET_ALL)
    public Response getAllStudents() {
        return studentService.getAllStudent();
    }
    @GetMapping(UrlConstraint.StudentManagement.GET_STUDENT_BYID)
    public Response getStudentById(@PathVariable("id") Long id) {
        return studentService.getStudentById(id);
    }
    @DeleteMapping(UrlConstraint.StudentManagement.DELETE)
    public Response deleteStudentById(@PathVariable("id") Long id) {
        return studentService.deleteById(id);
    }
    @PutMapping(UrlConstraint.StudentManagement.EDIT)
    public Response editStudentById(@PathVariable("id") Long id, @RequestBody StudentDto studentDto) {
        return studentService.editStudentById(id,studentDto);
    }
    @GetMapping(UrlConstraint.StudentManagement.GET_STUDENT_NAME_AND_AGE)
    public Response getStudentNameAndAge() {
        return studentService.getStudentNameAndAge();

    }

}
