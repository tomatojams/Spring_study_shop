package com.apple.shop.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  public boolean isUserLoggedIn() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    // 사용자가 인증되었는지 확인
    boolean isAuthenticated = authentication.isAuthenticated()
        && !(authentication.getPrincipal() instanceof String
        && authentication.getPrincipal().equals("anonymousUser"));

    return isAuthenticated;
  }

  public String getLoggedInUsername() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    // 인증된 사용자의 이름 가져오기
    if (authentication.getPrincipal() instanceof UserDetails) {
      return ((UserDetails) authentication.getPrincipal()).getUsername();
    }

    return "Anonymous";
  }
}
