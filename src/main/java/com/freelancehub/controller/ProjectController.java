package com.freelancehub.controller;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.freelancehub.model.Project;
import com.freelancehub.service.ProjectService;
import jakarta.validation.Valid;

@RestController
public class ProjectController {
	@Autowired
	private ProjectService projectService;
	 @GetMapping("/projects")
	    public List<Project> getProjects() {
	        return projectService.getAllProjects();
	    }
	 	
	 @PostMapping("/projects")
	 public Project addProject(@Valid @RequestBody Project project) {
	     return projectService.addProject(project);
	 }
	    
	    
	    @GetMapping("/projects/{id}")
	    public Project getProject(@PathVariable Long id) 
	    {
	    	return projectService.getProjectById(id);
	    }
	    @PutMapping("/projects/{id}")
	    public Project updateProject(
	            @PathVariable Long id,
	            @RequestBody Project project) {

	        project.setId(id);
	        return projectService.addProject(project);
	    }
	    @DeleteMapping("/projects/{id}")
	    public String deleteProject(@PathVariable Long id)
	    {
	        projectService.deleteProject(id);
	        return "Project deleted successfully";
	    }
}
