package com.abhishek.springjpabatchinsert.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "student", schema = "public")
@Entity
public class StudentEntity {
    @Id
    private String id;

    private String name;

    private Long age;
}
