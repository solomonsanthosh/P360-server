package com.p360server.server.controller;

import com.p360server.server.exception.PrintException;
import com.p360server.server.model.Competitive;
import com.p360server.server.repository.CompetitiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CompetitiveController {
    @Autowired
    private CompetitiveRepository competitiveRepository;

    @GetMapping("/allcompetitive")
    List<Competitive> getAllCompetitive() {
        return competitiveRepository.findAll();
    }

    @GetMapping("/competitive/{id}")
    Optional<Competitive> getCompetitiveById(@PathVariable Long id) {
        return competitiveRepository.findById(id);
    }

    @PostMapping("/competitive/create")
    Competitive newCompetitive(@RequestBody Competitive newCompetitive) {
        return competitiveRepository.save(newCompetitive);
    }

    @PutMapping("/competitive/update/{id}")
    Competitive updateCompetitive(@RequestBody Competitive newCompetitive, @PathVariable Long id) {
        try {
            return competitiveRepository.findById(id)
                    .map(competitive -> {
                        competitive.setCompetitive_topic(newCompetitive.getCompetitive_topic());
                        competitive.setStudent_rollno(newCompetitive.getStudent_rollno());
                        competitive.setCompetitive_percentage(newCompetitive.getCompetitive_percentage());
                        return competitiveRepository.save(competitive);
                    }).orElseThrow(() -> new PrintException("Competitive Update Failed"));
        } catch (PrintException e) {
            throw new RuntimeException(e);
        }
    }


    @DeleteMapping("/competitive/delete/{id}")
    String deleteCompetitive(@PathVariable Long id) throws PrintException {
        if (!competitiveRepository.existsById(id)) {
            throw new PrintException("Competitive not found");
        };
        competitiveRepository.deleteById(id);
        return "Competitive deleted successfully" + id;
    }
}
