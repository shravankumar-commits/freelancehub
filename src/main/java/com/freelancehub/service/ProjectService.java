package com.freelancehub.service;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.freelancehub.model.Project;
import com.freelancehub.repository.ProjectRepository;
import com.freelancehub.model.User;
import com.freelancehub.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
@Service
public class ProjectService {
@Autowired
private ProjectRepository projectRepository;
public List<Project> getAllProjects()
{
    return projectRepository.findAll();
}
@Autowired
private UserRepository userRepository;

public Project addProject(Project project)
{
	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

	String email = authentication.getName();

	System.out.println("Logged in user: " + email);
	User user = userRepository.findByEmail(email)
	        .orElseThrow(() -> new RuntimeException("User not found"));

    project.setUser(user);

    return projectRepository.save(project);
}

public Project getProjectById(Long id)
{
    return projectRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Project not found"));
}
public void deleteProject(Long id)
{
    projectRepository.deleteById(id);
}
}
