package com.example.LiquiStd.entity;

import jakarta.persistence.*;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String email;

    @ManyToOne
    private Course course;
    @ManyToOne
    private School school;
    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Date createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;
}

