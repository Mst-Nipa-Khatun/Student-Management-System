package com.StudentManagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;


@Setter
@Getter
@MappedSuperclass

public class BaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(updatable = false)
    private Long createdBy;


    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;
    private Long updatedBy;
    private boolean active;

    @PrePersist
    public void setPreInsertData() {
        this.createdAt = new Date();
        this.active = true;
    }

    @PreUpdate
    public void setPreUpdateData() {
        this.updateAt = new Date();
    }

}
