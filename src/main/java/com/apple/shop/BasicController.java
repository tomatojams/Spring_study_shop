package com.apple.shop;

import java.time.ZonedDateTime;
import org.springframework.stereotype.Controller;
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
public class BasicController {

  @GetMapping("/")
  String index() {  //HTML 반환이나 리다이렉트 명령은 실제로 본문응답이 없으므로   @ResponseBody 가 없음
    return "index";
  }

  @GetMapping("/about")
  @ResponseBody
  String About() {
    return "그거야 ";
  }

  @GetMapping("/date")
  @ResponseBody
  String Time() {
    Date today = new Date();
    // return today.toString();
    return ZonedDateTime.now().toString();
  }

}
