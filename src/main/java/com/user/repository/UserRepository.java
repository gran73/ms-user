package com.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.user.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

	@Query("SELECT u FROM User u WHERE u.email = :email")
	Optional<User> findbyEmail(@Param("email") String email);
	
}
