package com.ranierecosta.workshopmongoDB.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.ranierecosta.workshopmongoDB.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	@Query("{ 'title': { $regex: ?0, $options: 'i'} }")
	List<Post> searchTitle(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text);
	
}
