package com.apple.shop;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * DB 읽어오기 1. interface 형식으로  Repository 생성 2. 원하는 클래스에 등록 자신의 클래스를 형으로하는 클래스 등록 3. 검색함수등을 사용
 */
public interface ItemRepository extends JpaRepository<Item, Long> {
// DB 입출력을 도와주는 클래스가 생성됨


}
