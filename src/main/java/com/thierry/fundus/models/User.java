package com.thierry.fundus.models;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "user_details")
@JsonFilter(value = "UserFilter")
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    @Size(min=4, message="Please enter a username with at least 10 characters")
    @Column(unique=true)
    private String username;
    @Past
    private LocalDate birthDate;
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Request> requests;

    public User(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }
}
