package com.springwithmongo.basicspringmongo.Controllers;

import com.springwithmongo.basicspringmongo.Entities.User;
import com.springwithmongo.basicspringmongo.Exceptions.ExceptionResponse;
import com.springwithmongo.basicspringmongo.Services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value ="/{id}")
    public ResponseEntity<User> findById(@PathVariable long id){
        User user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<Object> insert(@Valid @RequestBody User user, Errors errors){
        if(errors.hasErrors()){
            StringBuilder stringBuilder = new StringBuilder();
            errors.getAllErrors().forEach(error -> stringBuilder.append(error.getDefaultMessage()).append("; "));
            return ResponseEntity.badRequest().body(new ExceptionResponse(new Date(), "Not Done", stringBuilder.toString()));
        }
        userService.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }

}
