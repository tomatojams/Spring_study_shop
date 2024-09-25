package com.apple.shop.Member;


import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by tomatojams on 24. 9. 13.
 */
public interface DBClinet_Member extends JpaRepository<Member, Long> {

  // Derived query methods
  // 여기서 DB를 username으로 찾는 함수를 만들었음 나머지는 자동생성
  Member findByUsername(String username);
}
