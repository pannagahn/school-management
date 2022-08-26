package com.school.app.service;

import com.school.app.data.model.Student;
import com.school.app.data.payload.request.StudentRequest;
import com.school.app.data.payload.response.StudentResponse;
import com.school.app.data.repository.StudentRepository;
import com.school.app.exception.MemberNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements iStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentResponse addStudent(StudentRequest studentRequest) {
        Student newStudent = new Student(studentRequest.getFirstName(), studentRequest.getLastName(), studentRequest.getAddress(), studentRequest.getEmail(), studentRequest.getPhoneNumber(), studentRequest.getMajor());
        studentRepository.save(newStudent);
        return new StudentResponse("Student Added Successfully");
    }

    @Override
    public Optional<Student> updateStudent(Integer studentId, StudentRequest studentRequest) {
        Optional<Student> student = studentRepository.findById(studentId);

        if (!student.isPresent()) {
            throw new MemberNotFoundException("Student", "Id", studentId);
        } else {
            student.get().setFirstName(studentRequest.getFirstName());
            student.get().setLastName(studentRequest.getLastName());
            student.get().setAddress(studentRequest.getAddress());
            student.get().setEmail(studentRequest.getEmail());
            student.get().setPhoneNumber(studentRequest.getPhoneNumber());
            student.get().setMajor(studentRequest.getMajor());

            studentRepository.save(student.get());
            return student;
        }
    }

    @Override
    public void deleteStudent(Integer studentId) {
        if(studentId.equals(studentRepository.findById(studentId).get().getId())) {
            studentRepository.deleteById(studentId);
        } else {
            throw new MemberNotFoundException("Student", "Id", studentId);
        }
    }

    @Override
    public Student getStudent(Integer studentId) {
        return studentRepository.findById(studentId).orElseThrow(() -> new MemberNotFoundException("Student", "Id", studentId));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
