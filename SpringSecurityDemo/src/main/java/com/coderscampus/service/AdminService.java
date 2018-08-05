package com.coderscampus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.coderscampus.domain.User;
import com.coderscampus.repositories.UserRepository;

@Service
public class AdminService {

  @Autowired
  private UserRepository userRepo;
  
  @Secured({"ROLE_ADMIN","ROLE_SUPERUSER"})
  public List<User> getAllUserAccounts () {
    return userRepo.findAll();
  }
}
