package com.sidda.library.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sidda.library.model.User;

@Repository
public class UserRepository {
	public List<User> users = new ArrayList<>();

	public User findByName(String name) {
		return users.stream().filter(u -> u.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
	}

	public void save(User u) {
		users.add(u);
	}

	public List<User> findAll() {
		return Collections.unmodifiableList(users);
	}

	public User findById(String id) {
		return users.stream().filter(u -> u.getId().equalsIgnoreCase(id)).findFirst().orElse(null);
	}
}
