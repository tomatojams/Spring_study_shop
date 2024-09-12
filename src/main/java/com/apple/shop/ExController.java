package com.apple.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;
import java.time.Duration;

@Controller
//@RestController
@RequiredArgsConstructor
public class ExController {

  // ChatClient 생성
  private final ChatClient chatClient;
  // 메세지
  String message = "즐거운 대화하자";


  @GetMapping("/ex")
  String ex() {

    String message = "즐거운 대화하자";

    Flux<String> output = chatClient.prompt()
        .system("한국어로, 이미지를 많이 써서 즐겁게") // 시스템 메시지 설정
        .user(message)
        .stream()
        .content(); // 응답 내용 가져오기

    // 스트리밍된 데이터를 실시간으로 출력
    output.subscribe(response -> System.out.print(response));
//    var boy = new member("Soma", 18);
//    System.out.println(boy.getAge());
//    System.out.println(boy.incAge());
//    System.out.println(boy.setAge(200));
    return "ex";
  }

}

// 연습용 일반 클래스
//class member {
//
//  public String name;
//  @Getter
//  @Setter
//  private Integer age;
//
//  public Integer incAge() {
//    this.age += 1;
//    return this.age;
//  }
//
//  public String setAge(Integer age) {
//    if (age > 100 || age < 0) {
//      return "입력값 오류" + age;
//    }
//    this.age = age;
//    return age.toString();
//  }
//
//  public member(String name, Integer age) {
//    this.name = name;
//    this.age = age;
//  }
//}