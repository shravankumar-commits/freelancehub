package com.freelancehub.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.freelancehub.model.Project;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.freelancehub.model.User;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long>{

	List<Project> findByuser(User user);
	
}
