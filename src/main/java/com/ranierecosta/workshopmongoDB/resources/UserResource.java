package com.ranierecosta.workshopmongoDB.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ranierecosta.workshopmongoDB.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		
		User raniere = new User("1", "Raniere", "raniere_@live.com");
		User ranis = new User("2", "Ranis", "me.raniere@gmail.com");
		
		List<User> list = new ArrayList<User>();
		
		list.addAll(Arrays.asList(raniere, ranis));
		
		return ResponseEntity.ok().body(list);
	}
	
}
