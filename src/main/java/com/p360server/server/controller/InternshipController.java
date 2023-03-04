package com.p360server.server.controller;

import com.p360server.server.exception.PrintException;
import com.p360server.server.model.Internship;
import com.p360server.server.model.Roadmap;
import com.p360server.server.repository.InternshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class InternshipController {
    @Autowired
    private InternshipRepository internshipRepository;

    @GetMapping("/internship")
    List<Internship> getInternship(){
        return internshipRepository.findAll();
    };
    @GetMapping("/internship/{id}")
    Optional<Internship> getSingleInternship(@PathVariable Long id){
        return internshipRepository.findById(id);
    };
    @PostMapping("/internship")
    Internship newInternship(@RequestBody Internship newInternship){
        return internshipRepository.save(newInternship);
    }
    @PutMapping("/roadmap/{id}")
    Internship updateInternship(@RequestBody Internship newInternship, @PathVariable Long id){
        try{
            return internshipRepository.findById(id)
                    .map(internship->{
                        internship.setInternship_name(newInternship.getInternship_name());
                        internship.setInernship_description(newInternship.getInernship_description());
                        internship.setLink(newInternship.getLink());

                        return internshipRepository.save(internship);
                    }).orElseThrow(() -> new PrintException("Internship Update Failed"));

        }catch (PrintException e){
            throw new RuntimeException(e);
        }
    };

}
