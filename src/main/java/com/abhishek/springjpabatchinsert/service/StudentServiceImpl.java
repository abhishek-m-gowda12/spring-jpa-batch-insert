package com.abhishek.springjpabatchinsert.service;

import com.abhishek.springjpabatchinsert.dto.Student;
import com.abhishek.springjpabatchinsert.entity.StudentEntity;
import com.abhishek.springjpabatchinsert.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll() {
        List<StudentEntity> students = (List<StudentEntity>) studentRepository.findAll();

        return students.stream().map(studentEntity -> {
            Student student = new Student();
            BeanUtils.copyProperties(studentEntity, student);
            return student;
        }).collect(Collectors.toList());
    }

    @Transactional
    public void addMany(List<Student> students) {
        List<StudentEntity> studentEntities = students.stream().map(student -> {
            StudentEntity studentEntity = new StudentEntity();
            BeanUtils.copyProperties(student, studentEntity);
            return studentEntity;
        }).collect(Collectors.toList());

        studentRepository.saveAll(studentEntities);
    }
}
