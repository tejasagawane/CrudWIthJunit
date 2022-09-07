package com.globant.CrudOperations;

import com.globant.CrudOperations.domain.Student;
import com.globant.CrudOperations.exception.BadRequestException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    @Autowired
    StudentRepo studentRepo;
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public void createStudent(Student student) {
        boolean ifExists = studentRepo.selectIfExistsEmail(student.getEmail());
        if(ifExists) {
            throw new BadRequestException("Email "+ student.getEmail() + " already taken");
        }
        studentRepo.save(student);
    }
}
