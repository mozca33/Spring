package com.example.projectmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectmanager.model.Project;
import com.example.projectmanager.dto.ProjectDTO;
import com.example.projectmanager.repository.ProjectRepository;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository repository;

    public Project createProject(ProjectDTO projectDTO) {
        return new Project(projectDTO.getName(), projectDTO.getDescription());
    }

    public List<Project> findAll() {
        return repository.findAll();
    }
   
    public Project save(Project project) {
        return repository.save(project);
    }
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Project findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
