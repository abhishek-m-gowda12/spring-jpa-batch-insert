package com.abhishek.springjpabatchinsert.controller;

import com.abhishek.springjpabatchinsert.dto.Student;
import com.abhishek.springjpabatchinsert.service.StudentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/student")
public class StudentController {

    private final StudentServiceImpl service;

    public StudentController(StudentServiceImpl service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addMany(@RequestBody List<Student> students) {

        service.addMany(students);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>> getAll() {

        List<Student> students = service.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(students);
    }
}
