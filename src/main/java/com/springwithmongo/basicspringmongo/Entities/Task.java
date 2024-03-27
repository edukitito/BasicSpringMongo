package com.springwithmongo.basicspringmongo.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Document(collation = "Task")
public class Task {
    @Id
    private String id;
    private String name;
    private String desption;

    private Set<User> users = new HashSet<>();

    public Task() {
    }

    public Task(String id, String name, String desption) {
        this.id = id;
        this.name = name;
        this.desption = desption;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesption() {
        return desption;
    }

    public void setDesption(String desption) {
        this.desption = desption;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void insertUser(User user) {
        users.add(user);
    }
}
