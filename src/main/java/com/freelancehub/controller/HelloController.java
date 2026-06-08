package com.freelancehub.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.freelancehub.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import com.freelancehub.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.*;

@RestController
public class HelloController {

	/*@GetMpping("/register")
	public User registerUser(@RequestBody User user) 
	{
		return user;
	}*/
	@Autowired
	private UserService userService;
    @GetMapping("/hello")
    public String hello() {
        return "Welcome to FreelanceHub!";
    }
    //@GetMapping("/users")
    //public List<User> getUser() 
    //{
    	//return userService.getAllUsers();
    //}
    @PostMapping ("/register")
    public User registerUser(@RequestBody User user) 
    {
    	return user;
    }
    @GetMapping("/users")
    public List<User> getUsers()
    {
    	/*return Arrays.asList(
    			new User(1L,"ShravanKumar","Java Dev"),
    			new User(2L,"Harsha","FrontendDev"),
    			new User(3L,"Aksthith","Backend Dev"));*/
    	return userService.getAllUsers();
    }
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) {

        if(id == 1) {
            return new User(1L, "ShravanKumar", "Java Dev");
        }
        else if(id == 2) {
            return new User(2L, "Harsha", "Frontend Dev");
        }
        else {
            return new User(3L, "Aksthith", "Backend Dev");
        }
    }
}		