package com.apple.shop.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JoinController {

  @Autowired
  private UserService userService;

  // 회원가입 페이지 렌더링
  @GetMapping("/join")
  public String joinPage() {
    return "join"; // join.pug 템플릿을 렌더링
  }

  // 회원가입 처리
  @PostMapping("/join")
  public String join(@RequestParam("username") String username,
      @RequestParam("password") String password,
      @RequestParam("passwordConfirm") String passwordConfirm) {
    // 비밀번호 일치 확인
    if (!password.equals(passwordConfirm)) {
      return "redirect:/join?error=passwordMismatch";
    }

    // 회원가입 처리
    try {
      userService.registerUser(username, password);
    } catch (IllegalArgumentException e) {
      return "redirect:/join?error=" + e.getMessage();
    }

    // 회원가입 성공 후 로그인 페이지로 리다이렉트
    return "redirect:/login";
  }
}
