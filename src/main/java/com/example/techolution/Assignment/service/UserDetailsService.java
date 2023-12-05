package com.example.techolution.Assignment.service;

import com.example.techolution.Assignment.entities.User;
import com.example.techolution.Assignment.exception.ResourceNotFoundException;
import com.example.techolution.Assignment.exception.UserAlreadyExistException;
import com.example.techolution.Assignment.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    public ResponseEntity<String> add(User user)
    {
        Optional<User> u = repo.findByUserName(user.getUserName());
        if(u.isPresent())
           throw new UserAlreadyExistException();
        user.setRole(user.getRole());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repo.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User Created..");
    }

    public User getUser(long id)
    {
        Optional<User> u = repo.findById(id);
        if(u.isPresent())
            return u.get();
        throw new ResourceNotFoundException();
    }

    public List<User> getAllUsers()
    {
        List<User> u = repo.findAll();
        return u;
    }

    public String updateUser(User u)
    {

            Optional<User> user = repo.findById(u.getId());
            if(user.isPresent())
            {
                user.get().setMobile(u.getMobile());
                repo.save(user.get());
                return "User Updated Successfully..";
            }
            else
                throw new ResourceNotFoundException();


    }
    public String deleteUser(long id){

        Optional<User> user = repo.findById(id);
        if(user.isPresent())
        {
            repo.delete(user.get());
            return "User deleted Successfully..";
        }
        else
            throw new ResourceNotFoundException();
    }
}
