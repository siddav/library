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
	
	public User save(User b) {
		return repository.save(b);
	}
	
	public User findByName(String name) {
		return repository.findByName(name);
	}

	public List<User> findAll() {
		return repository.findAll();
	}
}
