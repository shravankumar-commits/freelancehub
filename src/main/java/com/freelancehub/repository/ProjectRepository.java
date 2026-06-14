package com.freelancehub.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.freelancehub.model.Project;

public interface ProjectRepository extends JpaRepository<Project,Long>{

}
