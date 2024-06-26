package com.springwithmongo.basicspringmongo.Entities;

import com.springwithmongo.basicspringmongo.Validators.NotEmptyOrNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "User")
public class User {
    @Id
    private String id;
    @NotEmptyOrNull(message = "Email cannot be null or empty")
    private String email;
    @NotEmptyOrNull(message = "Name cannot be null or empty")
    private String name;
    @NotEmptyOrNull(message = "Cargo cannot be null or empty")
    private String cargo;
    @NotEmptyOrNull(message = "Password cannot be null or empty")
    private String password;
    @DBRef(lazy = true)
    private List<Task> tasks = new ArrayList<>();

    public User() {
    }

    public User(String id, String email, String name, String cargo, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.cargo = cargo;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public List<Task> getTasks() {
        return tasks;
    }

    public void insertTask(Task task) {
        tasks.add(task);
    }
}
