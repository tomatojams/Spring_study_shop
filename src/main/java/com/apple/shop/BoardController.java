package com.apple.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by tomatojams on 24. 8. 14.
 */

@Controller
@RequiredArgsConstructor
public class BoardController {

  private final BoardDBManager BoardDB;

  @GetMapping("/board")
  String board(Model model) {

    var result = BoardDB.findAll();
    model.addAttribute("board", result);
    System.out.println(result);
    return "board";
  }

}
