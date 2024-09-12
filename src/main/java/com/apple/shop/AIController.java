package com.apple.shop;

import org.springframework.http.MediaType;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
@RequiredArgsConstructor
public class AIController {

  // ChatClient 생성
  private final ChatClient chatClient;

  @GetMapping(value = "/ai/chat", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flux<String> exchat(
      @RequestParam(value = "message") String message) {
    // 클라이언트에서 받은 메시지를 사용하여 OpenAI API에 요청
    return chatClient.prompt()
        .system("한국어로, 이모지를 많이 써서 즐겁게") // 시스템 메시지 설정
        .user(message) // 클라이언트에서 전달된 메시지 사용
        .stream()
        .content()
        .delayElements(Duration.ofMillis(100)); // 0.1초 간격으로 메시지 전송
  }
}
