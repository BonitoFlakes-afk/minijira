package com.example.minijira;

import java.util.List;

import org.springframework.stereotype.Service;

//import javax.management.RuntimeErrorException;

@Service 
public class ProjectService {
   private final ProjectRepository repository;
   
   public ProjectService(ProjectRepository repository) {
    this.repository=repository;
   }

   public Project createProject(Project project){
    return repository.save(project);
   }

   public List<Project> getAllProjects(){
    return repository.findAll();
   }

   public Project getProjectById(Long id) {
    return repository.findById(id)
    .orElseThrow(() -> new RuntimeException("Project not found with id:"+id));
   }
}
