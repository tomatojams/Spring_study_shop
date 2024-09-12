package com.apple.shop;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ShopApplication {

  public static void main(String[] args) {
    SpringApplication.run(ShopApplication.class, args);

    System.out.println("URL: http://localhost:8080/");
    System.out.println("API 문서: http://localhost:8080/docs");

  }
}