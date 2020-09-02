package com.health.service;

import java.util.Set;

import com.health.domain.security.PasswordResetToken;
import com.health.domain.security.UserRole;
import com.health.model.User;


public interface UserService {
	
	
	PasswordResetToken getPasswordResetToken(final String token);
	
	void createPasswordResetTokenForUser(final User user, final String token);
	
	User findByUsername(String username);
	
	User findByEmail (String email);
	
	User createUser(User user, Set<UserRole> userRoles) throws Exception;
	
	User save(User user);
	
	User findByClassname(String username);
	

	
	
	
	
	
	
	
	
}
