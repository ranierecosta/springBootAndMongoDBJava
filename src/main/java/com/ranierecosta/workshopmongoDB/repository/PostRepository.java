package com.ranierecosta.workshopmongoDB.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ranierecosta.workshopmongoDB.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}