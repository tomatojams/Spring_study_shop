
// 다른데서도 이 라우터를 쓰기 위해서는 package로 경로 표시를 해야함
package com.apple.shop;

import static java.lang.Integer.parseInt;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*ITem API*/

@Controller
@RequiredArgsConstructor // Lombok을 사용하여 생성자를 자동 생성
public class ItemController { // JPA 사용1. repository  만들기 -> ItemRepository  등록

  private final ItemDBManager DBManager; // 2. 레포지토리 등록 CRUD 기능이 포함됨

  @GetMapping("/list")
  String List(Model model) {  //html에 전달기능가진 모델 불러옴
    List<Item> result = DBManager.findAll();     //3. Repository를 사용해 모든 Item을 조회
    model.addAttribute("items", result);    // 모델에 전달할 패러미터 추가   -> 전달되는 이름, 값
    System.out.println(result.toString());  // lombok 함수, 생각해도 됨
    return "list";
  }


  @GetMapping("/item/{id}")
    //  @PathVariable은 URL 경로의 일부를 메서드의 매개변수로 바인딩할 때 사용
  String detail(@PathVariable long id, Model model) {

    try {
      Optional<Item> item = DBManager.findById(id);
      if (item.isPresent()) { // 아이템을 찾았으면
        model.addAttribute("item", item.get());//optional은 .get()을 붙여야함
        return "detail";
      } else {
        return "notfound";
      }
    } catch (Exception e) {
      System.out.println("에러메세지" + e.getMessage());
      return "redirect:/list";
    }


  }

  @GetMapping("/item/new")
  String add() {
    return "addproduct";
  }

  @PostMapping("/item/add")
  String addPost(@ModelAttribute Item item) {
    DBManager.save(item);
    return "redirect:/list";
  }

  // 다른방법
  @PostMapping("/item/add2")
  String addPost2(String title, Integer price) {

    Item newItem = new Item();
    newItem.setTitle(title);
    newItem.setPrice(price);
    DBManager.save(newItem);
    return "redirect:/list";
  }


  // 다른 방법
  @PostMapping("/item/ad")
  String adPost(@RequestParam Map formData) {
    System.out.println(formData);
    // 함수에서 불러옴
    Item newItem = new Item();
    newItem.setTitle((String) formData.get("title"));
    newItem.setPrice(parseInt((String) formData.get("price")));
    DBManager.save(newItem);
    return "redirect:/list";
  }
}
