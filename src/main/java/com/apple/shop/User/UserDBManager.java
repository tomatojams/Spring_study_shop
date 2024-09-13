package com.apple.shop.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

/**
 * Created by tomatojams on 24. 9. 13.
 */
public interface UserDBManager extends JpaRepository<Users, Long> {

  User findByUsername(String username);
}
