package com.apple.shop;

import org.springframework.stereotype.Controller;
// 템플릿에 넣을 패러미터 모델
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by tomatojams on 2024-08-14
 */
@Controller
public class ItemController {

  @GetMapping("/list")
    //Model 형식의 파라미터추가
  String List(Model model) {
    // 파라미터에 템프릿 엔진을 통해 렌더링   -> 변수명, 값
    model.addAttribute("name", "토마토임");
    model.addAttribute("tag", "20억");
    return "list.html";
  }

}
