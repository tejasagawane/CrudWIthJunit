package com.globant.CrudOperations;

import com.globant.CrudOperations.domain.Student;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1/students/")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Student student) {
        studentService.createStudent(student);
        return new ResponseEntity<String>("Student created successfully",HttpStatus.CREATED);
    }
}
