package com.springwithmongo.basicspringmongo.Mongo;


import com.springwithmongo.basicspringmongo.Entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserMongoDb extends MongoRepository<User, Long> {
    User findUserByEmail(String email);
    boolean existsByEmail(String email);
}
