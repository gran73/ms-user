package com.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.user.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

	@Query("SELECT u from User u where u.email = :email")
	Optional<User> findByEmail(String email);
}
