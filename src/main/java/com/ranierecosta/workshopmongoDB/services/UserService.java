package com.ranierecosta.workshopmongoDB.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ranierecosta.workshopmongoDB.domain.User;
import com.ranierecosta.workshopmongoDB.dto.UserDTO;
import com.ranierecosta.workshopmongoDB.repository.UserRepository;
import com.ranierecosta.workshopmongoDB.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository; 
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repository.findById(id);
		
		return user.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado!"));
	}
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public void delete(String id) {
		
		findById(id);
		
		repository.deleteById(id);
	}
	
	public User update(User obj) {
		
		Optional<User> newObj = repository.findById(obj.getId());
		
		updateData(newObj.get(), obj);
		
		return repository.save(newObj.get());
	}
	
	private void updateData(User newObj, User obj) {		
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
		
}
