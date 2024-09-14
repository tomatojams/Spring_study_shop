package com.apple.shop.Advice_Global;

import java.security.Principal;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

// 모든 컨트롤러에 대해 공통 로직을 수행하는 ControllerAdvice
@ControllerAdvice
public class GlobalControllerAdvice {

  // 모든 요청에 대해 isloggedin 속성을 추가하여 로그인 상태를 템플릿에서 사용 가능하게 함
  @ModelAttribute("isloggedin")
  public boolean addIsLoggedInAttribute(Principal principal) {
    // Principal이 null이 아니면 로그인 상태로 간주
    return principal != null;
  }

  @ModelAttribute("username")
  public String addUsernameAttribute(Principal principal) {
    // Principal이 null이 아니면 사용자 이름을 가져오고, null이면 "Anonymous" 반환
    return principal != null ? principal.getName() : "Anonymous";
  }
}
