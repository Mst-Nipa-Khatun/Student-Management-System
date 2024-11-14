package com.StudentManagement.service;

import com.StudentManagement.Dto.Response;
import com.StudentManagement.Dto.StudentDto;

public interface StudentService {
     Response createStudent(StudentDto studentDto);
     Response getAllStudent();
     Response getStudentById(Long id);
     Response deleteById(Long id);
     Response editStudentById(Long id, StudentDto studentDto);
     Response getStudentNameAndAge();

}
