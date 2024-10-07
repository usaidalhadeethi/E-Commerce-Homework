package com.spring1.trendyol_odevi.repository;

import com.spring1.trendyol_odevi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    public Optional<User> getUserById (int userId);
}
