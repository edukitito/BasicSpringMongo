package com.springwithmongo.basicspringmongo.Services;

import com.springwithmongo.basicspringmongo.Entities.User;
import com.springwithmongo.basicspringmongo.Mongo.UserMongoDb;
import com.springwithmongo.basicspringmongo.Services.Exception.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserMongoDb mongo;

    public User findById(Long id){
        Optional<User> user = mongo.findById(id);
        return user.orElseThrow(() -> new NotFound(id));
    }

    public User insert(User user){
        if(mongo.existsByEmail(user.getEmail())){
            throw new RuntimeException("Email Já Cadastrado");
        }
        mongo.insert(user);
        return user;
    }

}
