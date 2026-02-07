package com.example.minijira;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController 
@RequestMapping("/projects")
public class ProjectController {
    
    private final ProjectService service;
    public ProjectController(ProjectService service) {
        this.service=service;
    }

    @PostMapping 
    public Project create(@RequestBody Project project) {
        return service.createProject(project);
    }

    @GetMapping
    public List<Project> getAll() {
        return service.getAllProjects();
    }
    
    
}
