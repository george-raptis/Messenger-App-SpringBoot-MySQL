package com.georgeraptis.messenger.dao;

import com.georgeraptis.messenger.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("SELECT id, username, password FROM User WHERE username= ?1 AND password = ?2")
	public String getUsernamePassword(String username, String password);

	@Query("SELECT id FROM User WHERE username = ?1")
	public String getId(String username);
	
	@Query("SELECT id FROM User WHERE username= ?1")
	public int getIdByUsername(String username);
}
