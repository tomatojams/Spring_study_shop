package com.apple.shop;

/**
 * Created by tomatojams on 2024-08-13
 */


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
public class ShopApplication {

  public static void main(String[] args) {
    SpringApplication.run(ShopApplication.class, args);

    System.out.println("접속할 수 있는 URL: http://localhost:8080/");


  }
}