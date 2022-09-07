package com.globant.CrudOperations;

import com.globant.CrudOperations.domain.Geneder;
import com.globant.CrudOperations.domain.Student;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@DataJpaTest
class StudentRepoTest {
    @Autowired
    StudentRepo studentRepo;

    @Test
    public void selectIfExistsEmail(){
        //Given student
        Student student = new Student(1L,"Tejas","tejas@gmail.com",Geneder.MALE);
        studentRepo.save(student);
        //When
        assertThat(studentRepo.selectIfExistsEmail(student.getEmail())).isTrue();
    }


    @Test
    public void selectIfNotExistsEmail(){
        //Given student
        Student student = new Student(1L,"Tejas","tejas@gmail.com",Geneder.MALE);
        //When
        assertThat(studentRepo.selectIfExistsEmail(student.getEmail())).isFalse();
    }

}