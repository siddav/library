package com.sidda.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sidda.library.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	@Query("SELECT u FROM User u where u.name = :name")
	User findByName(@Param("name") String name);
}
