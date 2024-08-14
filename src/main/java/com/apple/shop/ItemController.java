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

/**
 * Lombok 라이브러리에서 제공하는 것으로, 클래스의 final 필드와 @NonNull 필드를 초기화하는 생성자를 자동으로 생성합니다. 즉, final로 선언된 필드가
 * 있으면, 그 필드를 초기화하는 생성자가 자동으로 만들어집니다. 사용처: 불변 필드의 생성자를 자동으로 생성하여 코드의 간결성을 높일 때 사용됩니다.
 */

@Controller
@RequiredArgsConstructor // Lombok 문법 Reposity Constructor를 만들어야함
public class ItemController {


  private final ItemRepository ItemRepository; // 인터페이스를 변수로하는 클래스 등록

  @GetMapping("/list")
    //Model 형식의 파라미터추가
  String List(Model model) {
    List<Item> result = ItemRepository.findAll();

    String name = result.get(1).title;
    Integer price = result.get(1).price;

    // 파라미터에 템프릿 엔진을 통해 렌더링   -> 변수명, 값
    model.addAttribute("name", name);
    model.addAttribute("price", price);
    return "list.html";
  }

}
