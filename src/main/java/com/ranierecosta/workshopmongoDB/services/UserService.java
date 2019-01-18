package com.ranierecosta.workshopmongoDB.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ranierecosta.workshopmongoDB.domain.User;
import com.ranierecosta.workshopmongoDB.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository; 
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
}
