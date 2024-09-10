
// 다른데서도 이 라우터를 쓰기 위해서는 package로 경로 표시를 해야함
package com.apple.shop;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
// 템플릿에 넣을 패러미터 모델
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*ITem API*/

@Controller
@RequiredArgsConstructor // Lombok을 사용하여 생성자를 자동 생성
public class ItemController { // JPA 사용1. repository  만들기 -> ItemRepository  등록

  private final ItemDBManager DBManager; // 2. 레포지토리 등록 CRUD 기능이 포함됨

  @GetMapping("/list")
  String List(Model model) {  //html에 전달기능가진 모델 불러옴

    List<Item> result = DBManager.findAll();     //3. Repository를 사용해 모든 Item을 조회
    model.addAttribute("items", result);    // 모델에 전달할 패러미터 추가   -> 전달되는 이름, 값
    System.out.println(result.toString());    // toString이 생성된 경우 생략해도 출력됨
    return "list";
  }
}
