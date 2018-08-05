package com.coderscampus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderscampus.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
  User findByUsername(String username);

}
