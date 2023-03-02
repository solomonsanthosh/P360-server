package com.p360server.server.controller;

import com.p360server.server.exception.PrintException;
import com.p360server.server.model.Student;
import com.p360server.server.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {



    @Autowired
    private StudentRepository studentRepository;


    @GetMapping("/students")
    List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @GetMapping("/student/{id}")
    Optional<Student> getStudentById(@PathVariable Long id) {
        return studentRepository.findById(id);
    }

    @PostMapping("/student/create")
    Student newStudent(@RequestBody Student newStudent) {
        return studentRepository.save(newStudent);
    }

    @PutMapping("/student/update/{id}")
    Student updateStudent(@RequestBody Student newStudent, @PathVariable Long id) {
        try {
            return studentRepository.findById(id)
                    .map(student -> {
                        student.setStudent_name(newStudent.getStudent_name());
                        student.setStudent_rollno(newStudent.getStudent_rollno());
                        student.setStudent_cgpa(newStudent.getStudent_cgpa());
                        student.setStudent_marks_array(newStudent.getStudent_marks_array());
                        return studentRepository.save(student);
                    }).orElseThrow(() -> new PrintException("Student Update Failed"));
        } catch (PrintException e) {
            throw new RuntimeException(e);
        }
    }


    @DeleteMapping("/student/delete/{id}")
    String deleteStudent(@PathVariable Long id) throws PrintException {
        if (!studentRepository.existsById(id)) {
            throw new PrintException("Student not found");
        };
        studentRepository.deleteById(id);
        return "Student deleted successfully" + id;
    }



}
