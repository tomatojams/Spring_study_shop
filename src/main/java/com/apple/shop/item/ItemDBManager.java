package com.apple.shop.item;

import org.springframework.data.jpa.repository.JpaRepository;

// ORM DB 매니저 생성
/*
데이타베이스와 앱 간의 데이타 접근을 담당
CRUD 작업을 도와줌.,
Prisma와 비슷한 기능
입출력사이에서
JpaRepository의 기능이 들어감 (데이타 입출력, CRUD,트랜젝션)
<entity 이름, id컬럼의 타입>
*/
public interface ItemDBManager extends JpaRepository<Item, Long> {
// 인터페이스명과같은 클래스생성, CRUD 메서드가 자동으로 생성됩니다.

}
