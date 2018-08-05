package com.coderscampus.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;

import com.coderscampus.security.CustomSecurityUser;

@Entity
public class Authorities implements GrantedAuthority {
  private static final long serialVersionUID = -8123526131047887755L;
  private Long id;
  private String authority;
  private CustomSecurityUser user;
  
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  @Override
  public String getAuthority() {
    return authority;
  }

  public void setAuthority(String authority) {
    this.authority = authority;
  }

  @ManyToOne
  public CustomSecurityUser getUser() {
    return user;
  }

  public void setUser(CustomSecurityUser user) {
    this.user = user;
  }
}
