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
import com.freelancehub.dto.ProjectResponseDTO;

@Service
public class ProjectService {
@Autowired
private ProjectRepository projectRepository;
public List<Project> getAllProjects()
{
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String email = authentication.getName();
    
    User user = userRepository.findByEmail(email)
    		.orElseThrow(()-> new RuntimeException("User not found"));
    		
    		if(user.getRole().equals("CLIENT"))
    		{
    			return projectRepository.findByuser(user);
    		}
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
	
	project .setStatus("OPEN");
    project.setUser(user);

    return projectRepository.save(project);
}

public ProjectResponseDTO getProjectById(Long id)
{
     Project project= projectRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Project not found"));
    
     ProjectResponseDTO dto = new ProjectResponseDTO();
     dto.setId(project.getId());
     dto.setTitle(project.getTitle());
     dto.setDescription(project.getDescription());
     dto.setBudget(project.getBudget());
     dto.setStatus(project.getStatus());

     if (project.getAssignedFreelancer() != null) {
         dto.setAssignedFreelancer(
                 project.getAssignedFreelancer().getName());
     }

     return dto;
     
}
public void deleteProject(Long id)
{
    projectRepository.deleteById(id);
}
public Project completeProject(Long projectId) 
{
	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	
	String email = authentication.getName();
	
	User loggedInUser = userRepository.findByEmail(email)
			.orElseThrow(()->new RuntimeException("User not Found"));
	
	Project project = projectRepository.findById(projectId)
			.orElseThrow(()->new RuntimeException("Project not found"));
	
	if(project.getAssignedFreelancer()== null) {
		throw new RuntimeException("No Freelancer has been assigned to this project. ");
	}
	
	if(!project.getAssignedFreelancer().getId().equals(loggedInUser.getId())) {
		throw new RuntimeException("Only the assigned Freelancer can complete this project. ");
		
	}
	project.setStatus("COMPLETED");
	projectRepository.save(project);
	return project;
}
}
