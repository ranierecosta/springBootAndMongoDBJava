package com.ranierecosta.workshopmongoDB.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ranierecosta.workshopmongoDB.domain.Post;
import com.ranierecosta.workshopmongoDB.repository.PostRepository;
import com.ranierecosta.workshopmongoDB.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository; 

	public Post findById(String id) {
		Optional<Post> post = repository.findById(id);
		
		return post.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado!"));
	}
	
	public List<Post> findByTitle(String text) {
		//return repository.findByTitleContainingIgnoreCase(text);
		return repository.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		
		return repository.fullSearch(text, minDate, maxDate); 
	}
		
}