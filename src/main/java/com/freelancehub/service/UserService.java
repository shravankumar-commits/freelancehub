package com.freelancehub.service;
import java.util.*;
//import org.springframework.beans.factory.annotation.AutoWired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.freelancehub.model.User;
import com.freelancehub.repository.UserRepository;
@Service
public class UserService
{
	@Autowired
	private UserRepository userRepository;
	public List<User>getAllUsers()
	{
		return userRepository .findAll();
	}
	public User addUser(User user) 
	{
		return userRepository.save(user);
	}
	public User getUserById(Long id) 
	{
		return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
	}
	public String deleteUser(Long id) 
	{
	    	userRepository.deleteById(id);
	    	return "User deleted successfully";
    }
	public User updateUser(Long id, User updatedUser)
	{
	    User existingUser = userRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("User not found"));

	    existingUser.setName(updatedUser.getName());
	    existingUser.setRole(updatedUser.getRole());

	    return userRepository.save(existingUser);
	}
	 
}