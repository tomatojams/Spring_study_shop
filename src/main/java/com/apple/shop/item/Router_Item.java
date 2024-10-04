
// 다른데서도 이 라우터를 쓰기 위해서는 package로 경로 표시를 해야함
package com.apple.shop.item;

import static java.lang.Integer.parseInt;

import java.util.List;
import java.util.Map;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/*ITem API*/

@Controller
@RequiredArgsConstructor // Lombok을 사용하여 생성자를 자동 생성
public class Router_Item { // JPA 사용1. repository  만들기 -> ItemRepository  등록

  private final DBClient_Item DBClientItem; // 2. 레포지토리 등록 CRUD 기능이 포함됨
  private final Service_Item serviceItem;

  // Lombok 미사용시: 현재 클래스 ItemController 생성할때,
  // 다른 클래스 DBClient_Item, itemService도 생성해서 주입 (싱글톤 패턴)<- 의존성 주입
  // new를 밖에서 뽑아서 주입해줌  -> new 키워드 없앰 -> 의존성이 줄어듬 (클래스간 커플링(간섭) 줄임)


  // 리스트
  @GetMapping("/list")
  String List(Model model) {  //html에 전달기능가진 모델 불러옴
    List<Item> result = DBClientItem.findAll();     //3. Repository를 사용해 모든 Item을 조회
    model.addAttribute("items", result);    // 모델에 전달할 패러미터 추가   -> 전달되는 이름, 값
//    System.out.println(result.toString());  // lombok 함수, .toString()은 생략해도 됨
    return "list";
  }

  // detail 정보
  @GetMapping("/item/{id}")
  //  @PathVariable은 URL 경로의 일부를 메서드의 매개변수로 바인딩할 때 사용
  String detail(@PathVariable long id, Model model) {

    return serviceItem.detailItem(id, model);
  }


  // 아이템 수정페이지
  @GetMapping("/item/edit/{id}")
  String Edit(@PathVariable long id, Model model) {
    model.addAttribute("item", DBClientItem.findById(id).get());
    return "editItem";
  }

  // 수정
  @PostMapping("/item/edit")
  //@ModelAttribute -> req.body를 자동으로 지정된 object에 매핑해줌
  // 이때 item.setId()같은 바인딩이 되기때문에 @Setter를 필요로함
  String editItem(@ModelAttribute Item item, RedirectAttributes redirectAttributes) {
    serviceItem.updateItem(item, redirectAttributes);
    return "redirect:/list";
  }

  // 삭제
  @DeleteMapping("/item/delete")
  // ?id=${itemId} 가 @RequestParam에 의해서 전달받음
  ResponseEntity<String> deleteItem(@RequestParam long id) {

    if (DBClientItem.findById(id).isPresent()) {
      DBClientItem.deleteById(id);
    }
    //AJAX일때는 응답을 보내야 해서 redirect는 어려움
    return ResponseEntity.ok("아이템이 삭제되었습니다.");
  }

  // 신규등록 페이지
  @GetMapping("/item/new")
  String add() {
    return "newItem";
  }

  //저장1 @Service 이용
  @PostMapping("/item/add")
  String addPost(String title, Integer price, String username,
      RedirectAttributes redirectAttributes) {
    serviceItem.saveItem(title, price, username, redirectAttributes); //redirectAttributes 로 메세지도 전송
    return "redirect:/list";
  }

  //다른방법2 객체로 받아옴
  @PostMapping("/item/add2")
  String addPost(@ModelAttribute Item item) {
    DBClientItem.save(item);
    return "redirect:/list";
  }

  // 다른방법3 Map으로 받아옴 -> String 캐스팅을 해야함
  @PostMapping("/item/ad")
  String adPost(@RequestParam Map formData) {
    System.out.println(formData);
    // 함수에서 불러옴
    Item newItem = new Item();
    newItem.setTitle((String) formData.get("title"));
    newItem.setPrice(parseInt((String) formData.get("price")));
    DBClientItem.save(newItem);
    return "redirect:/list";
  }
}
