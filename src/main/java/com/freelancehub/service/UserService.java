package com.freelancehub.service;
import java.util.*;
import org.springframework.stereotype.Service;
import com.freelancehub.model.User;
@Service
public class UserService 
{
	private List<User>users=new ArrayList<>();
	public UserService() 
	{
		users.add(new User(1L, "Shravan Kumar", "Java Dev"));
        users.add(new User(2L, "Harsha", "Frontend Dev"));
        users.add(new User(3L, "Akshith", "Backend Dev"));
	}
	public List<User>getAllUsers()
	{
		return users;
	}
	public User addUser(User user)
	{
		users.add(user);
		return user;
	}
	public User updateUser(Long id, User updatedUser)
	{
	    for(User user : users)
	    {
	        if(user.getId().equals(id))
	        {
	            user.setName(updatedUser.getName());
	            user.setRole(updatedUser.getRole());

	            return user;
	        }
	    }

	    return null;
	}
	public String deleteUser(Long id) 
	{
		users.removeIf(user->user.getId().equals(id));
		return "USer deleted successfully";
	}
}
