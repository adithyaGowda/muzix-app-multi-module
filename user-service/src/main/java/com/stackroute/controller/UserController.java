package com.stackroute.controller;

import com.stackroute.domain.User;
import com.stackroute.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("user")
    public ResponseEntity<?> saveUser(@RequestBody User user){

        ResponseEntity responseEntity;
        try{
            userService.saveUser(user);
            responseEntity = new ResponseEntity("Successfully created", HttpStatus.CREATED);
        }
        catch(Exception e){
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);

        }

        return responseEntity;
    }

    @GetMapping("user")
    public ResponseEntity<?> getAllUsers(){
        ResponseEntity responseEntity;
        try{
            responseEntity = new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
        }
        catch (Exception e){
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        }

        return  responseEntity;
    }

    @GetMapping("user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id){
        ResponseEntity responseEntity;

        try{
            responseEntity = new ResponseEntity<User>(userService.getUserById(id), HttpStatus.OK);
        }catch (Exception e){
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        }

        return responseEntity;
    }
}
