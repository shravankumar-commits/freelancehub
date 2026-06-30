package com.freelancehub.service;
import java.util.*;
//import org.springframework.beans.factory.annotation.AutoWired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.freelancehub.model.User;
import com.freelancehub.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService
{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	public List<User>getAllUsers()
	{
		return userRepository .findAll();
	}
	public User addUser(User user) 
	{
		String encryptedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encryptedPassword);
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
	public String login(String email, String password)
	{
	    System.out.println("Email = " + email);
	    System.out.println("Password = " + password);

	    User user = userRepository.findByEmail(email)
	            .orElseThrow(() -> new RuntimeException("User not found"));

	    System.out.println("DB User = " + user.getEmail());

	    if(!passwordEncoder.matches(password, user.getPassword()))
	    {
	        //throw new RuntimeException("Invalid password");
	    	return "Invalid Password";
	    }

	    return "Login Successful";
	}
}