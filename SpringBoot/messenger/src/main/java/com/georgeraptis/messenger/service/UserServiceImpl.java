package com.georgeraptis.messenger.service;

import com.georgeraptis.messenger.dao.UserRepository;
import com.georgeraptis.messenger.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository theUserRepository) {
    	userRepository = theUserRepository;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int id) {

        Optional<User> result = userRepository.findById(id);
        
        User user = null;
        
        if (result.isPresent()) {
        	user = result.get();
        } else {
        	throw new RuntimeException("user not found id: " + id);
        }
		return user;
    }

    @Override
    public void create(User user) {
    	userRepository.save(user);
    }

    @Override
    public void deleteById(int id) {
    	userRepository.deleteById(id);
    }

	@Override
	public String getUsernamePassword(String username, String password) {
		return userRepository.getUsernamePassword(username, password);
	}

	@Override
	public String getId(String username) {
		return userRepository.getId(username);
	}

	@Override
	public int getIdByUsername(String username) {
		return userRepository.getIdByUsername(username);
	}
}
