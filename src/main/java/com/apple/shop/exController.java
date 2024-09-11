package com.apple.shop;

import lombok.Getter;
import lombok.Setter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by tomatojams on 24. 9. 11.
 */
@Controller
public class exController {

  @GetMapping("/ex")
  String ex() {
    var boy = new member("Soma", 18);
    System.out.println(boy.getAge());
    System.out.println(boy.incAge());
    System.out.println(boy.setAge(200));

    return "ex";
  }

}

class member {

  public String name;
  @Getter
  @Setter
  private Integer age;

  public Integer incAge() {
    this.age += 1;
    return this.age;
  }

  public String setAge(Integer age) {
    if (age > 100 || age < 0) {
      return "입력값 오류" + age;
    }
    this.age = age;
    return age.toString();
  }

  public member(String name, Integer age) {
    this.name = name;
    this.age = age;
  }
}