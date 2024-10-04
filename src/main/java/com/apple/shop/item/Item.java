package com.apple.shop.item;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
DB 테이블 생성
 */
@Entity // 데이터베이스 테이블과 매핑되는 클래스임을 명시
@ToString // 객체의 문자열 표현을 자동 생성
@Getter
@Setter
public class Item {

  /*  protected :같은 폴더에서만 사용가능:아무것도 안붙인거랑 같음 -> 상속한 클래스는 사용가능
      private : 내부에서만 사용가능;
      public : 외부에서 사용가능*/
  @Id   //  키컬럼
  @GeneratedValue(strategy = GenerationType.IDENTITY)  // 자동증가 아이디

  private Long id;  // public -> 외부에서 접근가능하게
  
  private String username;

  private String title;
  // 필수데이터 columnDefinition ="TEXT" 컬럼타입 지정도 가능
  @Column(nullable = false, length = 100)
  private Integer price;
}
