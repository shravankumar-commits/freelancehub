package com.freelancehub.service;
import java.util.*;
//import org.springframework.beans.factory.annotation.AutoWired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.freelancehub.model.User;
import com.freelancehub.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.freelancehub.jwt.Jwtutil;
import com.freelancehub.dto.LoginResponse;
@Service
public class UserService
{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private Jwtutil jwtutil;
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
	public LoginResponse login(String email, String password)
	{
		User user = userRepository.findByEmail(email)
	            .orElseThrow(() -> new RuntimeException("User not found"));

	    	boolean result =passwordEncoder.matches(password, user.getPassword());
	    	//System.out.println("Password Match"+ result);
	    	
	    if(!result)
	    {
	    	return new LoginResponse(null, "Invalid Password",null,null,null);	    }

	    String token = jwtutil.generateToken(user.getEmail());
	    return new LoginResponse(token, "Login Successful",user.getName(),user.getEmail(),user.getRole());
	}
}