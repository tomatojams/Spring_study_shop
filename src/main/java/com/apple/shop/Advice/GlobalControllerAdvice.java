package com.apple.shop.Advice;


import com.apple.shop.User.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;


// 모든 컨트롤러에 대해 공통 로직을 수행하는 ControllerAdvice
@ControllerAdvice
@RequiredArgsConstructor
public class GlobalControllerAdvice {

  private final UserService userService;


  // 모든 요청에 대해 isloggedin 속성을 추가하여 로그인 상태를 템플릿에서 사용 가능하게 함
  @ModelAttribute("isloggedin")
  public boolean addIsLoggedInAttribute() {
    // UserService를 사용하여 로그인 여부를 확인
    return userService.isUserLoggedIn();
  }
}
