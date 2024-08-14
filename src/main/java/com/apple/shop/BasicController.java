package com.apple.shop;

import java.time.ZonedDateTime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by tomatojams on 2024-08-14
 */
@Controller
public class BasicController {


  // 파일로 보낼때
  @GetMapping("/")
  String Hi() {
    return "index.html";
  }

  @GetMapping("/about")
  //문자로 보낼때
  @ResponseBody
  String About() {
    return "그거야 ";
  }

  @GetMapping("/date")
  @ResponseBody
  String Time() {
    Date today = new Date();
//    return today.toString();
    return ZonedDateTime.now().toString();
  }

}
