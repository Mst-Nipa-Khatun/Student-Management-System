package com.StudentManagement.Dto;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@MappedSuperclass

public class BaseDto {
    private long id;

}
