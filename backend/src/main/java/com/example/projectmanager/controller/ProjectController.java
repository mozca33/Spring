package com.example.projectmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.projectmanager.model.Project;
import com.example.projectmanager.service.ProjectService;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService service;

    @GetMapping
    public List<Project> getProjects() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return service.save(project);
    }
    
    @PutMapping("/{id}")
    public Project putMethodName(@PathVariable Long id, @RequestBody Project project) {
        Project existingProduct = service.findById(id);
        if (existingProduct != null) {
            existingProduct.setName(project.getName());
            existingProduct.setDescription(project.getDescription());
            
            return service.save(existingProduct);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        service.deleteById(id);
    }
}