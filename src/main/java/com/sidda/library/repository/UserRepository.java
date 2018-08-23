package com.sidda.library.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.sidda.library.db.DataHolder;
import com.sidda.library.model.User;

@Repository
public class UserRepository {
	
	@Autowired
	@Qualifier("inmemory")
	private DataHolder datasource;

	public User findByName(String name) {
		return datasource.getUsers().stream().filter(u -> u.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
	}

	public void save(User u) {
		datasource.save(u);
	}

	public List<User> findAll() {
		return datasource.getUsers();
	}

	public User findById(String id) {
		return datasource.getUsers().stream().filter(u -> u.getId().equalsIgnoreCase(id)).findFirst().orElse(null);
	}
}
