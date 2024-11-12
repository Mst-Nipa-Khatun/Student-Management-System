package com.StudentManagement.service.Impl;

import com.StudentManagement.Dto.Response;
import com.StudentManagement.Dto.StudentDto;
import com.StudentManagement.entity.StudentEntity;
import com.StudentManagement.repository.StudentRepository;
import com.StudentManagement.service.StudentService;
import com.StudentManagement.service.UtilityService;
import com.StudentManagement.utils.ResponseBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    public StudentServiceImpl(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Response createStudent(StudentDto studentDto) {
        StudentEntity studentEntity = studentRepository.
                findByNameAndActiveTrue(studentDto.getName());

        if (studentEntity == null) {
            studentEntity = modelMapper.map(studentDto, StudentEntity.class);
            StudentEntity student = studentRepository.save(studentEntity);
            StudentDto convertedStudentDto = modelMapper.map(student, StudentDto.class);


            return ResponseBuilder.getSuccessResponse(HttpStatus.CREATED, convertedStudentDto,
                    "Successfully created student");

        }
        return ResponseBuilder.getFailureResponse(HttpStatus.BAD_REQUEST, null, "Student already exists");
    }
}
