package com.example.expense_tracker.repository;

import com.example.expense_tracker.entity.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findbyEmail(String email);
}
