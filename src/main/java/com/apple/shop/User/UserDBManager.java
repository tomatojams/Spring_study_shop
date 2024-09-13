package com.apple.shop.User;


import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by tomatojams on 24. 9. 13.
 */
public interface UserDBManager extends JpaRepository<User, Long> {

  User findByUsername(String username);
}
