package com.ucelebi.service;

import java.util.Optional;

import com.ucelebi.model.User;

public interface UserService {
	Optional<User> findByUsername(String Username);
	User createUser(User user);
}
