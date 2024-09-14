package com.apple.shop.Member;

import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
// UserDetailsService 를 완성해서 간접적으로 사용됨
// Spring Security가 인증 과정에서 DB의 사용자 정보를 로드하는 데 사용
public class MemberConfirmDB implements UserDetailsService {

  @Autowired
  private MeberDBmanager userDBManager;


  @Override
  // UserDetailsService 에서 가져온 메서드를 실제로 구현
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Member user = userDBManager.findByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException("User not found");
    }
    // springframework 에서 제공하는 형식으로 인증
    // DB 인증이라 OAuth에서는 안쓰임
    return new org.springframework.security.core.userdetails.User(
        user.getUsername(),
        user.getPassword(),
        user.isEnabled(),
        true,
        true,
        true,
        Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
    );
  }

}
