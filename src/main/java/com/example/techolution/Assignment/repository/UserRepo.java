package com.example.techolution.Assignment.repository;

import com.example.techolution.Assignment.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    public Optional<User> findByUserName(String userName);
}
