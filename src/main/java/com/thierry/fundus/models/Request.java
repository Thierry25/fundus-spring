package com.thierry.fundus.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import net.minidev.json.annotate.JsonIgnore;


@Entity(name = "requests")
public class Request {
    @Id
    @GeneratedValue
    private Integer id;
    @Size(min=5, message="The title should contain at least 5 characters")
    private String title;
    @Size(min=10, message = "Description should at least contain 10 characters")
    private String description;
    @Min(value=10, message = "The amount should be at least be 10 dollars")
    private Integer amount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    public Request(){};

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
