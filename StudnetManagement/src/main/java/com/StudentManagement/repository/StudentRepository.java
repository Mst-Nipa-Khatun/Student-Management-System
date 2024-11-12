package com.StudentManagement.repository;

import com.StudentManagement.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
    //StudentEntity findByIdAndActiveTrue(Long id);
    StudentEntity findByNameAndActiveTrue(String name);
}
