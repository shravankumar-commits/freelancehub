package com.freelancehub.controller;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.freelancehub.model.Project;
import com.freelancehub.service.ProjectService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/projects")
public class ProjectController {
	@Autowired
	private ProjectService projectService;
	 @GetMapping
	    public List<Project> getProjects() {
	        return projectService.getAllProjects();
	    }
	 	
	 @PostMapping
	 public Project addProject(@Valid @RequestBody Project project) {
	     return projectService.addProject(project);
	 }
	    
	    
	    @GetMapping("/{id}")
	    public Project getProject(@PathVariable Long id) 
	    {
	    	return projectService.getProjectById(id);
	    }
	    @PutMapping("/{id}")
	    public Project updateProject(
	            @PathVariable Long id,
	            @RequestBody Project project) {

	        project.setId(id);
	        return projectService.addProject(project);
	    }
	    @DeleteMapping("/{id}")
	    public String deleteProject(@PathVariable Long id)
	    {
	        projectService.deleteProject(id);
	        return "Project deleted successfully";
	    }
}
