package com.ucelebi.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ucelebi.model.User;
import com.ucelebi.service.UserService;

@Service
public class UserDetailsServiseImpl implements UserDetailsService{

	@Autowired
	UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> user=userService.findByUsername(username);
		
		user.orElseThrow(()->new UsernameNotFoundException("Not Found: "+username));
		
		return user.map(UserDetailsImpl::new).get();
	}

}
