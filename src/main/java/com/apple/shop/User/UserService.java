package com.apple.shop.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserDBManager userDBManager;

  @Autowired
  private PasswordEncoder passwordEncoder;

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

  // 회원가입 기능 추가
  public void registerUser(String username, String rawPassword) {
    // 중복 사용자 확인
    if (userDBManager.findByUsername(username) != null) {
      throw new IllegalArgumentException("이미 존재하는 사용자 이름입니다.");
    }

    // 비밀번호 암호화
    String encodedPassword = passwordEncoder.encode(rawPassword);

    // 사용자 정보 저장
    User user = new User();
    user.setUsername(username);
    user.setPassword(encodedPassword);
    user.setEnabled(true); // 계정 활성화 설정

    userDBManager.save(user);
  }

}
