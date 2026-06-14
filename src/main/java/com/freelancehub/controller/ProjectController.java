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
	    public Project addProject(@RequestBody Project project) {
	        return projectService.addProject(project);
	    }
}
