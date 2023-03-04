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
    @GetMapping("/roadmap")
    List<Roadmap> getRoadmap(){
        return roadmapRepository.findAll();
    }


    @GetMapping("/roadmap/{id}")
    Optional<Roadmap> getSingleRoadmap(@PathVariable Long id){
        return roadmapRepository.findById(id);
    }
    @PostMapping("/roadmap")
    Roadmap newRoadMap(@RequestBody Roadmap newRoadMap){
        return roadmapRepository.save(newRoadMap);
    }


    @PutMapping("/roadmap/{id}")
    Roadmap updateRoadmap(@RequestBody Roadmap newRoadmap, @PathVariable Long id){
        try{
            return roadmapRepository.findById(id)
                    .map(roadmap->{
                        roadmap.setTopic(newRoadmap.getTopic());
                        roadmap.setSub_topic(newRoadmap.getSub_topic());
                        roadmap.setDescription(newRoadmap.getDescription());
                        roadmap.setLinks(newRoadmap.getLinks());
                        return roadmapRepository.save(roadmap);
                    }).orElseThrow(() -> new PrintException("Roadmap Update Failed"));

        }catch (PrintException e){
            throw new RuntimeException(e);
        }
    };
    @DeleteMapping("/roadmap/{id}")
    String DeleteRoadmap(@PathVariable Long id) throws PrintException {
        if(!roadmapRepository.existsById(id)){
            throw new PrintException("Roadmap not found");
        }
        roadmapRepository.deleteById(id);
        return "Roadmap deleted successfully"+id;
    }
}
