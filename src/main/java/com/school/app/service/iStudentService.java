package com.school.app.service;

import com.school.app.data.model.Student;
import com.school.app.data.payload.request.StudentRequest;
import com.school.app.data.payload.response.StudentResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface iStudentService {
    StudentResponse addStudent(StudentRequest studentRequest);
    Optional<Student> updateStudent(Integer studentId, StudentRequest studentRequest);
    void deleteStudent(Integer studentId);
    Student getStudent(Integer studentId);
    List<Student> getAllStudents();
}
