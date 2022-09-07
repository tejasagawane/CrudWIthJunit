package com.globant.CrudOperations;

import com.globant.CrudOperations.domain.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {
    @Autowired
    StudentController studentController;

    @Mock
    StudentService studentService;


    @Mock
    Student student;

    @BeforeEach
    void setUp() {
        studentController = new StudentController(studentService);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllStudents() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        when(studentController.getAllStudents()).thenReturn(studentList);
        assertEquals(studentService.getAllStudents().size(),studentList.size());
    }

    @Test
    void create() {
        assertEquals(studentController.create(student).getStatusCode(), HttpStatus.CREATED);
    }
}