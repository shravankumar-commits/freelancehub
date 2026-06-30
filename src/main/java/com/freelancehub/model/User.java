package com.freelancehub.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import jakarta.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List; 
@Entity

@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message="Name cannot be empty")
	private String name;
	@NotBlank(message="Role cannot be empty")
	private String role;
	@OneToMany(mappedBy = "user")
	private List<Project> projects;
	@Column(unique = true)
	@NotBlank(message = "Email cannot be empty")
	private String email;
	@NotBlank(message = "Password cannot be empty")
	private String password;
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List <Bid>bids;
	public User() 
	{
		
	}
	public User(Long id,String name,String role) 
	{
		this.id=id;
		this.name=name;
		this.email=email;
		this.password=password;
		this.role=role;
		
	}
	public Long getId() 
	{
		return id;
	}
	public void setId(Long id) 
	{
		this.id=id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name=name;
	}
	public String getRole() 
	{
		return role;
	}
	public void setRole(String role) 
	{
		this.role=role;
	}
	public List<Project> getProjects()
	{
	    return projects;
	}

	public void setProjects(List<Project> projects)
	{
	    this.projects = projects;
	}
	public List <Bid>getBids()
	{
		return bids;
	}
	public void setBids(List<Bid>bids) 
	{
		this.bids = bids;
	}
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password=password;
	}
}

