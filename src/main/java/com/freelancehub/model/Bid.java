package com.freelancehub.model;
import jakarta.persistence.*;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
@Entity
@Table(name = "bids")
public class Bid {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double amount;
	private String proposal;
	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	public Bid() 
	{
		
	}
		public Bid(Long id, Double amount, String proposal) 
		{
			this.id=id;
			this.amount=amount;
			this.proposal=proposal;
		}
		public Long getId() 
		{
			return id;
		}
		public void setId(Long id) 
		{
			this.id=id;
		}
		public Double getAmount() 
		{
			return amount;
		}
		public void setAmount(Double amount) 
		{
			this.amount=amount;
		}
		public String getProposal() 
		{
			return proposal;
		}
		public void setProposal(String proposal)
		{
			this.proposal=proposal;
		}
		public Project getProject() 
		{
			return project;
		}
		public void setProject(Project project) 
		{
			this.project = project;
		}
		public User getUser() 
		{
			return user;
		}
		public void setUser(User user) 
		{
			this.user=user;
		}
}
