package com.apple.shop;

import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AIController {

  private final ChatClient chatClient;

  // 대화 히스토리를 저장할 변수
  private final List<String> chatHistory = new ArrayList<>();

  @GetMapping("/ai/chat")
  @ResponseBody
  public String exchat(@RequestParam(value = "message") String message) {
    // 사용자 메시지를 대화 히스토리에 추가
    chatHistory.add("User: " + message);

    // 대화 히스토리를  시스템에 전달
    String combinedHistory = String.join("\n", chatHistory);

    // ChatClient를 사용하여 이전 대화 내용을 포함한 새로운 요청 생성
    String response = chatClient.prompt()
        .system("한국어로, 이모지를 많이 써서 즐겁게")
        .user(combinedHistory)  // 이전 대화를 포함하여 전달
        .call().content();

    // AI의 응답도 대화 히스토리에 추가
    chatHistory.add("AI: " + response);
    return response;
  }
}
