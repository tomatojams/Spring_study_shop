package com.apple.shop.Member;


import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by tomatojams on 24. 9. 13.
 */
public interface MeberDBmanager extends JpaRepository<Member, Long> {

  Member findByUsername(String username);
}
