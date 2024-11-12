package com.StudentManagement.service;

import com.StudentManagement.Dto.Response;
import com.StudentManagement.Dto.StudentDto;

public interface StudentService {
     Response createStudent(StudentDto studentDto);

}
