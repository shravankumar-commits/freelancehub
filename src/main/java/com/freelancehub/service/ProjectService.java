package com.freelancehub.service;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.freelancehub.model.Project;
import com.freelancehub.repository.ProjectRepository;
@Service
public class ProjectService {
@Autowired
private ProjectRepository projectRepository;
public List<Project> getAllProjects()
{
    return projectRepository.findAll();
}
public Project addProject(Project project) 
{
	return projectRepository.save(project);
}
}
