package com.p360server.server.controller;

import com.p360server.server.exception.PrintException;
import com.p360server.server.model.StudentInternship;
import com.p360server.server.repository.StudentInternshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentInternshipController {

    @Autowired
    private StudentInternshipRepository studentInternshipRepository;


    @GetMapping("/studentinternships")
    List<StudentInternship> getAllStudentInternships() {
        return studentInternshipRepository.findAll();
    }


    @GetMapping("/studentinternship/{id}")
    Optional<StudentInternship> getStudentInternshipById(@PathVariable Long id) {
        return studentInternshipRepository.findById(id);
    }

    @PostMapping("/studentinternship/create")
    StudentInternship newStudentInternship(@RequestBody StudentInternship newStudentInternship) {
        return studentInternshipRepository.save(newStudentInternship);
    }

    @PutMapping("/studentinternship/update/{id}")
    StudentInternship updateStudentInternship(@RequestBody StudentInternship newStudentInternship, @PathVariable Long id) {
        try {
            return studentInternshipRepository.findById(id)
                    .map(studentInternship -> {
                        studentInternship.setInternship_name(newStudentInternship.getInternship_name());
                        studentInternship.setInernship_description(newStudentInternship.getInernship_description());
                        studentInternship.setInternship_score(newStudentInternship.getInternship_score());
                        studentInternship.setStudent_rollno(newStudentInternship.getStudent_rollno());
                        return studentInternshipRepository.save(studentInternship);
                    }).orElseThrow(() -> new PrintException("Internship Update Failed"));
        } catch (PrintException e) {
            throw new RuntimeException(e);
        }
    }


    @DeleteMapping("/studentinternship/delete/{id}")
    String deleteStudentInternship(@PathVariable Long id) throws PrintException {
        if (!studentInternshipRepository.existsById(id)) {
            throw new PrintException("Internship not found");
        };
        studentInternshipRepository.deleteById(id);
        return "Internship deleted successfully" + id;
    }
}
