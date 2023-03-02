package com.p360server.server.controller;

import com.p360server.server.exception.PrintException;
import com.p360server.server.model.Project;
import com.p360server.server.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProjectController {
    @Autowired
    private ProjectRepository projectRepository;


    @GetMapping("/projects")
    List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @GetMapping("/project/{id}")
    Optional<Project> getProjectById(@PathVariable Long id) {
        return projectRepository.findById(id);
    }

    @PostMapping("/project/create")
    Project newProject(@RequestBody Project newProject) {
        return projectRepository.save(newProject);
    }

    @PutMapping("/project/update/{id}")
    Project updateProject(@RequestBody Project newProject, @PathVariable Long id) {
        try {
            return projectRepository.findById(id)
                    .map(project -> {
                        project.setProject_name(newProject.getProject_name());
                        project.setProject_description(newProject.getProject_description());
                        project.setStudent_rollno(newProject.getStudent_rollno());
                        project.setProject_score(newProject.getStudent_rollno());
                        return projectRepository.save(project);
                    }).orElseThrow(() -> new PrintException("Project Update Failed"));
        } catch (PrintException e) {
            throw new RuntimeException(e);
        }
    }


    @DeleteMapping("/project/delete/{id}")
    String deleteProject(@PathVariable Long id) throws PrintException {
        if (!projectRepository.existsById(id)) {
            throw new PrintException("Project not found");
        };
        projectRepository.deleteById(id);
        return "Project deleted successfully" + id;
    }
}
