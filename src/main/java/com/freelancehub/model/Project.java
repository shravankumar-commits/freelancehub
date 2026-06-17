package com.freelancehub.model;
import jakarta.persistence.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "projects")
public class Project {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@NotBlank(message = "Title cannot be empty")
private String title;
@NotBlank(message = "Description cannot be empty")
private String description;
@NotNull(message = "Budget cannot be empty")
private Double budget;
@JsonIgnore
@ManyToOne
@JoinColumn(name="user_id")
private User user;
@JsonIgnore
@OneToMany(mappedBy = "project")
private List<Bid> bids;
public Project() 
{
}

public Project(Long id, String title, String description, Double budget) 
{
this.title = title;
this.description = description;
this.budget = budget;
this.id=id;
}
public Long getId() 
{
	return id;
}
public void setId(Long id) 
{
	this.id=id;
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
public User getUser()
{
    return user;
}

public void setUser(User user)
{
    this.user = user;
}
public List<Bid> getBids()
{
    return bids;
}

public void setBids(List<Bid> bids)
{
    this.bids = bids;
}
}

