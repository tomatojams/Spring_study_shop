package com.apple.shop;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;
import lombok.ToString;
import org.w3c.dom.Text;

/*
DB 테이블 생성
 */
@Entity // 데이터베이스 테이블과 매핑되는 클래스임을 명시
@ToString // 객체의 문자열 표현을 자동 생성
public class Item {


  @Id   //  키컬럼
  @GeneratedValue(strategy = GenerationType.IDENTITY)  // 자동증가 아이디
  public Long id;  // public -> 외부에서 접근가능하게
  @Column(nullable = false, length = 100)   // 필수데이터 columnDefinition ="TEXT" 컬럼타입 지정도 가능
  public String title;
  public Integer price;

}
