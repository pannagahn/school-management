package com.school.app.controller;

import com.school.app.data.model.Student;
import com.school.app.data.payload.request.StudentRequest;
import com.school.app.data.payload.response.StudentResponse;
import com.school.app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/all")
    private ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    private ResponseEntity<Student> getStudent(@PathVariable("id")  Integer studentId) {
        Student student = studentService.getStudent(studentId);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping("/add")
    private ResponseEntity<StudentResponse> addStudent(@RequestBody StudentRequest studentRequest) {
        StudentResponse studentResponse = studentService.addStudent(studentRequest);
        return new ResponseEntity<>(studentResponse, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<Optional<Student>> updateStudent (@PathVariable("id") Integer studentId, @RequestBody StudentRequest studentRequest) {
        Optional<Student> student = studentService.updateStudent(studentId, studentRequest);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<?> deleteStudent (@PathVariable("id") Integer studentId) {
        studentService.deleteStudent(studentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
