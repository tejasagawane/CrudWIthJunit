package com.globant.CrudOperations;

import com.globant.CrudOperations.domain.Geneder;
import com.globant.CrudOperations.domain.Student;
import com.globant.CrudOperations.exception.BadRequestException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Autowired
    StudentService studentService;

    @Mock
    StudentRepo studentRepo;

    @BeforeEach
    void setUp() {
        studentService = new StudentService(studentRepo);
    }


    @Test
    void getAllStudentsTest() {
        studentService.getAllStudents();
        verify(studentRepo).findAll();
    }

    @Test
    void createStudent() {
        Student student = new Student(1L,"Tejas","tejas@gmail.com", Geneder.MALE);
        studentService.createStudent(student);
        verify(studentRepo).save(student);
    }

    @Test
    void createStudentIfEmailExists() {
        Student student = new Student(1L,"Tejas","tejas@gmail.com", Geneder.MALE);
        given(studentRepo.selectIfExistsEmail(any())).willReturn(true);
        assertThatThrownBy(() -> studentService.createStudent(student))
                .isInstanceOf(BadRequestException.class)
                .hasMessageContaining("Email "+ student.getEmail() + " already taken");
    }

}