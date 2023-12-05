package com.example.techolution.Assignment.controller;

import com.example.techolution.Assignment.entities.User;
import com.example.techolution.Assignment.exception.ResourceNotFoundException;
import com.example.techolution.Assignment.exception.UserAlreadyExistException;
import com.example.techolution.Assignment.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDetailsService service;
    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody User user){
        try {
            return service.add(user);
        }
        catch (UserAlreadyExistException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/get")
    public ResponseEntity<Object> getUser(@RequestParam("id") long id){
        try {
            User u = service.getUser(id);
            return ResponseEntity.status(HttpStatus.OK).body(u);
        }
        catch (ResourceNotFoundException ex)
        {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
       List<User> Users = service.getAllUsers();
       return ResponseEntity.status(HttpStatus.OK).body(Users);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateUser(@RequestBody User u)
    {
        try {
            String res = service.updateUser(u);
            return ResponseEntity.status(HttpStatus.OK).body(res);
        }
        catch (ResourceNotFoundException ex)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteUser(@RequestParam("id") long id)
    {
        try {
            String res = service.deleteUser(id);
            return ResponseEntity.status(HttpStatus.OK).body(res);
        }
        catch (ResourceNotFoundException ex)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }

    }
}
