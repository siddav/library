package com.sidda.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sidda.library.model.User;
import com.sidda.library.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public void save(User b) {
		repository.save(b);
	}
	
	public User findByName(String name) {
		return repository.findByName(name);
	}

	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(String id) {
		return repository.findById(id);
	}
}
