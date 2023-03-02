package com.p360server.server.controller;

import com.p360server.server.exception.PrintException;
import com.p360server.server.model.Internship;
import com.p360server.server.repository.InternshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class InternshipController {

    @Autowired
    private InternshipRepository internshipRepository;

    @GetMapping("/internships")
    List<Internship> getAllInternships() {
        return internshipRepository.findAll();
    }

    @GetMapping("/internship/{id}")
    Optional<Internship> getInternshipById(@PathVariable Long id) {
        return internshipRepository.findById(id);
    }

    @PostMapping("/internship/create")
    Internship newInternship(@RequestBody Internship newInternship) {
        return internshipRepository.save(newInternship);
    }

    @PutMapping("/internship/update/{id}")
    Internship updateInternship(@RequestBody Internship newInternship, @PathVariable Long id) {
        try {
            return internshipRepository.findById(id)
                    .map(internship -> {
                        internship.setInternship_name(newInternship.getInternship_name());
                        internship.setInernship_description(newInternship.getInernship_description());
                        internship.setInternship_score(newInternship.getInternship_score());
                        internship.setStudent_rollno(newInternship.getStudent_rollno());
                        return internshipRepository.save(internship);
                    }).orElseThrow(() -> new PrintException("Internship Update Failed"));
        } catch (PrintException e) {
            throw new RuntimeException(e);
        }
    }


    @DeleteMapping("/internship/delete/{id}")
    String deleteInternship(@PathVariable Long id) throws PrintException {
        if (!internshipRepository.existsById(id)) {
            throw new PrintException("Internship not found");
        };
        internshipRepository.deleteById(id);
        return "Internship deleted successfully" + id;
    }
}
