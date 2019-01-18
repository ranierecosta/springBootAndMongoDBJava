package com.ranierecosta.workshopmongoDB.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ranierecosta.workshopmongoDB.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
