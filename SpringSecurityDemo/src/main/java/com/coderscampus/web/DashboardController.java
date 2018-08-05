package com.coderscampus.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.coderscampus.domain.User;
import com.coderscampus.service.AdminService;

@Controller
public class DashboardController {
  
  @Autowired
  private AdminService adminService;
  
  @GetMapping("/dashboard")
  public String getDashboard (@AuthenticationPrincipal User user, ModelMap model) {
    System.out.println(user);
    
    model.put("user", user);
    List<User> allUserAccounts = adminService.getAllUserAccounts();
    
    return "dashboard";
  }
}
