package com.freelancehub.service;
import java.util.*;
import org.springframework.stereotype.Service;
import com.freelancehub.model.User;
@Service
public class UserService {
	public List<User> getAllUsers()
	{
		return Arrays.asList(
				new User(1L,"ShravanKumar","Java Dev"),
    			new User(2L,"Harsha","FrontendDev"),
    			new User(3L,"Aksthith","Backend Dev"));
	}
}
