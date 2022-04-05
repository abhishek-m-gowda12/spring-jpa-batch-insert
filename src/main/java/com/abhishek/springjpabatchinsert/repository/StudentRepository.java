package com.abhishek.springjpabatchinsert.repository;

import com.abhishek.springjpabatchinsert.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<StudentEntity, String> {
}
