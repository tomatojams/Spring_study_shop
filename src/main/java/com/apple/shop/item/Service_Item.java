package com.apple.shop.item;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by tomatojams on 24. 9. 12.
 */

// @Service @Repository @Component는 외부반복사용
@Service
@RequiredArgsConstructor
public class Service_Item {

  private final DBClient_Item DBManager;

  // 저장
  public void saveItem(String title, Integer price, RedirectAttributes redirectAttributes) {
    // 예외처리시 서비스 함수에서는 리다이렉트 X, return X, throw new Exception O

    try {
      if (title.length() > 50) {
        throw new IllegalArgumentException("제품 이름이 너무 깁니다.");
      }
      if (price < 100) {
        throw new IllegalArgumentException("가격이 잘못되었습니다.");
      }
      Item newItem = new Item();
      newItem.setTitle(title);
      newItem.setPrice(price);
      DBManager.save(newItem);
      redirectAttributes.addFlashAttribute
          ("message", "아이템이 성공적으로 추가되었습니다.");
    } catch (Exception e) {

      System.out.println(e.getMessage());
      redirectAttributes.addFlashAttribute
          ("message", "아이템 추가 중 오류가 발생했습니다.");
    }

  }

  // detail
  public String detailItem(Long id, Model model) {

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

  // update
  public void updateItem(Item item, RedirectAttributes redirectAttributes) {

    try {
      // 존재하는 데이터가 맞으면 업데이트
      if (DBManager.findById(item.getId()).isPresent()) {
        if (item.getTitle().length() > 50) {
          throw new IllegalArgumentException("제품 이름이 너무 깁니다.");
        }
        if (item.getPrice() < 100) {
          throw new IllegalArgumentException("가격이 잘못되었습니다.");
        }

        DBManager.save(item);
        //
        // 업데이트 성공 메시지
        // "redirect:/list" 와 연동되어 message 전송
        // .addFlashAttribute는 일회성 메세지로 자동제거
        redirectAttributes.addFlashAttribute
            ("message", "아이템이 성공적으로 업데이트되었습니다.");
      } else {
        redirectAttributes.addFlashAttribute
            ("message", "아이템을 찾을 수 없습니다.");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      redirectAttributes.addFlashAttribute
          ("message", "업데이트 중 오류가 발생했습니다.");
    }

  }


}
