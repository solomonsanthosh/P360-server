package com.p360server.server.controller;

import com.p360server.server.exception.PrintException;
import com.p360server.server.model.Roadmap;
import com.p360server.server.repository.RoadmapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RoadmapController {
    @Autowired
    private RoadmapRepository roadmapRepository;

    @PostMapping("/roadmap/create")
    Roadmap newRoadmap(@RequestBody Roadmap newRoadmap) {
        return roadmapRepository.save(newRoadmap);
    }

    @GetMapping("/roadmaps")
    List<Roadmap> getAllRoadmaps() {
        return roadmapRepository.findAll();
    }

    @GetMapping("/roadmap/{id}")
    Optional<Roadmap> getRoadmapById(@PathVariable Long id) {
        return roadmapRepository.findById(id);
    }

    @PutMapping("/roadmap/update/{id}")
    Roadmap updateRoadmap(@RequestBody Roadmap newRoadmap,@PathVariable Long id) {
        try {
            return roadmapRepository.findById(id)
                    .map(roadmap -> {
                        roadmap.setRoadmap_topic(newRoadmap.getRoadmap_topic());
                        roadmap.setRoadmap_subtopic(newRoadmap.getRoadmap_subtopic());
                        roadmap.setRoadmap_description(newRoadmap.getRoadmap_description());
                        roadmap.setRoadmap_youtube(newRoadmap.getRoadmap_youtube());
                        return roadmapRepository.save(roadmap);
                    }).orElseThrow(() -> new PrintException("Roadmap Update Failed"));
        } catch (PrintException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/roadmap/delete/{id}")
    String deleteRoadmap(@PathVariable Long id) throws PrintException {
        if (!roadmapRepository.existsById(id)) {
            throw new PrintException("Roadmap not found");
        };
        roadmapRepository.deleteById(id);
        return "Roadmap Deleted Successfully " + id;
    }



}
