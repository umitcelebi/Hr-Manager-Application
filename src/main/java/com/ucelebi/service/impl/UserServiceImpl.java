package com.ucelebi.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucelebi.model.User;
import com.ucelebi.repo.UserRepository;
import com.ucelebi.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Optional<User> findByUsername(String Username) {
		return userRepository.findByUsername(Username);
	}

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

}
