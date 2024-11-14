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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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
        StudentEntity studentEntity = studentRepository.findByNameAndActiveTrue(studentDto.getName());

        if (studentEntity == null) {
            studentEntity = modelMapper.map(studentDto, StudentEntity.class);
            StudentEntity student = studentRepository.save(studentEntity);
            StudentDto convertedStudentDto = modelMapper.map(student, StudentDto.class);


            return ResponseBuilder.getSuccessResponse(HttpStatus.CREATED, convertedStudentDto,
                    "Successfully created student");

        }
        return ResponseBuilder.getFailureResponse(HttpStatus.BAD_REQUEST, null, "Student already exists");
    }

    @Override
    public Response getAllStudent() {//hoy nai... list of student ekhane asbe tomi return a ekta diyecho....fix koro...
        List<StudentEntity> students = studentRepository.findAllByAndActiveTrue();
        //StudentEntity student= new StudentEntity();
        //List<StudentDto> studentDtos = new ArrayList<>();

       if (!students.isEmpty()) {


           List<StudentDto> studentDtos = new ArrayList<>();
           for (StudentEntity student1 : students) {
                  StudentDto studentDto = modelMapper.map(student1, StudentDto.class);
                  studentDtos.add(studentDto);
           }
           return ResponseBuilder.getSuccessResponse(HttpStatus.OK,studentDtos,
                   "Successfully retrieved student");
       }
        return ResponseBuilder.getFailureResponse(HttpStatus.BAD_REQUEST, null,
                "No students found");

    }
    @Override
    public Response getStudentById(Long id) {
        StudentEntity studentEntity = studentRepository.findByIdAndActiveTrue(id);
        if (studentEntity != null) {
            StudentDto studentDto = modelMapper.map(studentEntity, StudentDto.class);
           return ResponseBuilder.getSuccessResponse(HttpStatus.OK,studentDto,
                   "Successfully retrieved student");
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.BAD_REQUEST,null,
                "FAil response");
    }

    @Override
    public Response deleteById(Long id) {
        StudentEntity studentEntity = studentRepository.findByIdAndActiveTrue(id);
        if (studentEntity != null) {
            studentEntity.setActive(false);
            studentRepository.save(studentEntity);
            StudentDto studentDto = modelMapper.map(studentEntity, StudentDto.class);
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK,studentDto,"Successfully deleted student");
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.BAD_REQUEST, null, "Student not found");
    }

    @Override
    public Response editStudentById(Long id, StudentDto studentDto) {
        StudentEntity studentEntity = studentRepository.findByIdAndActiveTrue(id);
        if (studentEntity != null) {
            studentEntity=modelMapper.map(studentDto, StudentEntity.class);
            studentEntity.setActive(true);
            StudentEntity student=studentRepository.save(studentEntity);
            StudentDto convertedStudentDto = modelMapper.map(student, StudentDto.class);
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK,convertedStudentDto,
                    "Successfully updated student");
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.BAD_REQUEST, null,
                "Student not found");
    }

    @Override
    public Response getStudentNameAndAge() {
        List<StudentEntity> studentEntity = studentRepository.findByAgeLessThanEqualAndActiveTrue(30);
        if (!studentEntity.isEmpty()) {
            List<StudentDto> studentDtos = new ArrayList<>();
            for (StudentEntity student1 : studentEntity) {
                char ch=student1.getName().toLowerCase().charAt(0);
                if(ch == 'a'|| ch == 'e'|| ch == 'i' ||ch == 'o' ||ch == 'u'){
                    StudentDto studentDto1 = modelMapper.map(student1, StudentDto.class);
                    studentDtos.add(studentDto1);
                }
            }
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK,studentDtos,
                    "Successfully retrieved student");
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.NO_CONTENT,null,
                "Student not found");
    }
}
