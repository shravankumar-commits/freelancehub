package com.freelancehub.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
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
	
	public User() 
	{
		
	}
	public User(Long id,String name,String role) 
	{
		this.id=id;
		this.name=name;	
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
}

