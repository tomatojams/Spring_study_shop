package com.apple.shop.User;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {  // 클래스 이름 변경

  @GetMapping("/login")
  public String LoginPage(Model model) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    // 로그인 여부
    boolean isAuthenticated =
        authentication.isAuthenticated() && !(authentication.getPrincipal() instanceof String
            && authentication.getPrincipal().equals("anonymousUser"));

    // 사용자이름
    String username = (authentication.getPrincipal() instanceof UserDetails)
        ? ((UserDetails) authentication.getPrincipal()).getUsername()
        : "Anonymous";

    // 로그인 여부를 모델에 추가
    model.addAttribute("isAuthenticated", isAuthenticated);
    model.addAttribute("username", username);
    return "login";  // 렌더링할 Pug 템플릿 파일
  }
}
