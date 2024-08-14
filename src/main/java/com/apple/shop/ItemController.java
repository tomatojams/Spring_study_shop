package com.apple.shop;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
// 템플릿에 넣을 패러미터 모델
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by tomatojams on 2024-08-14
 */

@Controller
@RequiredArgsConstructor // Lombok 문법 안그러면 생성자 Reposity Constructor를 만들어야함
public class ItemController {


  private final ItemRepository ItemDB; // 인터페이스를 변수로하는 클래스 등록

  @GetMapping("/list")
    //Model 형식의 파라미터추가
  String List(Model model) {
    List<Item> result = ItemDB.findAll();
    // 파라미터에 템프릿 엔진을 통해 렌더링   -> 전달되는 변수명, 값
    model.addAttribute("items", result);

    // toString이 생성된 경우 생략해도 출력됨
    System.out.println(result.toString());

    return "list.html";
  }

}
