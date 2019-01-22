package com.georgeraptis.messenger.service;

import com.georgeraptis.messenger.entity.User;

import java.util.List;

public interface UserService {

    public List<User> getAll();

    public User findById(int id);

    public void create(User user);

    public void deleteById(int id);
    
	public String getUsernamePassword(String username, String password);
 
	public String getId(String username);
	
	public int getIdByUsername(String username);
}
