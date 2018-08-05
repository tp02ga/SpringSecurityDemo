package com.coderscampus.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.coderscampus.domain.User;

@Controller
public class DashboardController {
  
  @GetMapping("/dashboard")
  public String getDashboard (@AuthenticationPrincipal User user, ModelMap model) {
    System.out.println(user);
    
    model.put("user", user);
    
    return "dashboard";
  }
}
