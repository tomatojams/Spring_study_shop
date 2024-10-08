package com.apple.shop;

import static java.lang.Integer.parseInt;

import java.time.ZonedDateTime;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;



/*//API 제작방법
@GetMapping <- URL
@ResponseBody
함수 <-*/
/*   파일 전송시, static 폴더에서 선택하려면 redirect를 쓴다
      return "redirect:/index.html";
   그외에는 templates에서 찾음*/

// controller -> router
@Controller
@RequiredArgsConstructor
public class Router_Basic {

  // DBManager는 클래스에서 가져옴 함수시작전
  private final BoardDBManager BoardDB;


  @GetMapping("/")
  String index(Model model) {  //HTML 반환이나 리다이렉트 명령은 실제로 본문응답이 없으므로   @ResponseBody 가 없음
    // String 리턴값이 'index'로 Spring MVC가 String으로 템플릿파일을 찾음 => index.pug
    return "index";
  }

  @GetMapping("/about")
  @ResponseBody
  String About() {
    return "그거야 ";
  }

  @GetMapping("/board")
  String board(Model model) {

    var result = BoardDB.findAll();
    model.addAttribute("board", result);
    //System.out.println(result);
    return "board";
  }

  @GetMapping("/register")
  String register(Authentication auth) {

    if (auth != null) {

      return "redirect:/my-page";
    }
    return "error";

  }

  @GetMapping("/date")
  @ResponseBody
  String Time() {
    Date today = new Date();
    // return today.toString();
    return ZonedDateTime.now().toString();
  }

  @GetMapping("/ai")
  String ex() {
    return "ai";
  }

}
