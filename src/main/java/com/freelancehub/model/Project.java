package com.freelancehub.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "projects")
public class Project {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@NotBlank(message = "Title cannot be empty")
private String title;
@NotBlank(message = "Description cannot be empty")
private String description;
@NotNull(message = "Budget cannot be empty")
private Double budget;
public Project() 
{
}

public Project(Long id, String title, String description, Double budget) 
{
this.title = title;
this.description = description;
this.budget = budget;
}
public String getTitle() 
{
return title;
}
public void setTitle(String title) 
{
this.title=title;	
}
public String getDescription() 
{
return description;	
}
public void setDescription(String description) 
{
	this.description=description;
}
public Double getBudget() 
{
return budget;	
}
public void setBudget(Double budget) 
{
 this.budget = budget;	
}

}

