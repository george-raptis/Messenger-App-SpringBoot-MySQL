package com.georgeraptis.messenger.controller;

import com.georgeraptis.messenger.entity.User;
import com.georgeraptis.messenger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class UserRestController {

    private UserService userService;

    @Autowired
    public UserRestController(UserService theUserService) {
        userService = theUserService;
    }

    @GetMapping("/users")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/users/{userId}")
    public User findById(@PathVariable int userId) {

        User user = userService.findById(userId);
        return user;
    }
    
    @PostMapping("/users")
    public User create(@RequestBody User user) {
    	
    	user.setId(0);
    	
    	userService.create(user);
    	
    	return user;
    }
    
    @PutMapping("/users")
    public User update(@RequestBody User user) {
    	
    	userService.create(user);
    	
    	return user;
    }
    
    @DeleteMapping("/users/{userId}")
    public User deleteById(@PathVariable int userId) {
    	
    	User tempUser = userService.findById(userId);
    	
    	if (tempUser == null ) {
    		throw new RuntimeException("Employee not found id: " + userId);
    	}
    	
    	userService.deleteById(userId);
    	
    	return null;
    }
    
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> json) {
    	
    	String username = json.get("username");
    	String password = json.get("password");
    	
    	String checkLogin = userService.getUsernamePassword(username, password);

		if (username != null && checkLogin != null && password != null) {
			json.put("id", userService.getId(username));
			return json;
		}
		else {
			return null;
}
    	
    }
}
