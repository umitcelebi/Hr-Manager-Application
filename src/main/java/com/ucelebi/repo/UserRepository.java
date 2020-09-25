package com.ucelebi.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ucelebi.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUsername(String Username);
}
