package com.thierry.fundus.controllers;


import com.thierry.fundus.models.Request;
import com.thierry.fundus.models.User;
import com.thierry.fundus.services.RequestService;
import com.thierry.fundus.services.UserDaoService;
import com.thierry.fundus.utils.Filtering;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserDaoService userDaoService;
    private final Filtering filtering;

    private final RequestService requestService;

    public UserController(UserDaoService userDaoService, Filtering filtering, RequestService requestService){
        this.userDaoService = userDaoService;
        this.filtering = filtering;
        this.requestService = requestService;
    }

    @GetMapping
    public MappingJacksonValue getAllUsers(){
        var users =  userDaoService.getAllUsers();
        return filtering.filter(users, "UserFilter", "username", "birthDate");
    }

    @GetMapping("/{id}")
    public MappingJacksonValue getUserById(@PathVariable Integer id){
        var user = userDaoService.findUserById(id);
        var entityModel = EntityModel.of(user);
        var link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsers());
        entityModel.add(link.withRel("all_users"));
        return filtering.filter(entityModel, "UserFilter", "username");
    }

    @GetMapping(params = "username")
    public MappingJacksonValue getUserByUsername(@RequestParam String username){
        var user =  userDaoService.findByUsername(username);
        var entityModel = EntityModel.of(user);
        var link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsers());
        entityModel.add(link.withRel("all_users"));
        return filtering.filter(entityModel, "UserFilter", "id", "birthDate");
    }



    @PatchMapping("/{id}")
    public MappingJacksonValue updateUser(@PathVariable Integer id, @Valid @RequestBody User userData){
        var updatedUser = userDaoService.updateUser(id, userData);
        return filtering.filter(updatedUser, "UserFilter", "username");
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Integer id){
        userDaoService.deleteUser(id);
    }

    @PostMapping
    public MappingJacksonValue createNewUser(@Valid @RequestBody User userData){
        var user = userDaoService.createUser(userData);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return filtering.filter(ResponseEntity.created(location).build(), "UserFilter", "username", "birthDate");
    }

    @GetMapping("/{id}/requests")
    public ResponseEntity<List<Request>> getAllRequests(@PathVariable Integer id){
        var user = userDaoService.findUserById(id);
        return new ResponseEntity<>(user.getRequests(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/requests/filter", params = "startsWith")
    public ResponseEntity<List<Request>> getFilteredRequests(@PathVariable Integer id, @RequestParam String startsWith){
        var requests = userDaoService.getFilteredRequests(id, startsWith);

        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

   @PostMapping("/{id}/requests")
    public ResponseEntity<Request> createNewRequest(@PathVariable Integer id, @Valid @RequestBody Request request){
        var user = userDaoService.findUserById(id);
        var newRequest = requestService.createNewRequest(user, request);
        var location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newRequest.getId())
                .toUri();
        return ResponseEntity.created(location).build();
   }

}
