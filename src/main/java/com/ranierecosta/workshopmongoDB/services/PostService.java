package com.ranierecosta.workshopmongoDB.services;

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
		
}