package com.apple.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;

import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tomatojams on 24. 9. 12.
 */
@RestController
@RequiredArgsConstructor
public class ChatController {

  private final ChatClient chatClient;
  String message = "즐거운 대화하자";

  public void getChatClient() {
    chatClient.prompt().system("한국어로, 이미지를 많이써서 즐겁게").user(message).call().content();


  }
}
