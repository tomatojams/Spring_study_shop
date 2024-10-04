package com.apple.shop.Member;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
// UserDetailsService 를 완성해서 간접적으로 사용됨
// Spring Security가 인증 과정에서 DB의 사용자 정보를 로드하는 데 사용

// 클래스 가이드를 주기위한 implements
@RequiredArgsConstructor
public class MemberDetailService implements UserDetailsService {

  @Autowired
  private final DBClinet_Member DBClientMember;


  @Override
  // UserDetailsService 에서 가져온 메서드를 실제로 구현
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    // Derived query methods -> 레포지토리에서 만듬-> 행을 하나 찾아옴
    // DB에서 찾아오면 optional
    Member user = DBClientMember.findByUsername(username);
    System.out.println("USerID: " + user.getId());
    if (user == null) {
      throw new UsernameNotFoundException("User not found");
    }

    // 권한 리스트 SimpleGrantedAuthority -> API에서 현재유저 권한 출력가능
    List<GrantedAuthority> Authoritys = new ArrayList<>();
    Authoritys.add(new SimpleGrantedAuthority("ROLE_USER"));

    // springframework 에서 제공하는 형식으로 인증
    // DB 인증이라 OAuth에서는 안쓰임
    //  리턴후 쿠키있음 -> JSESSIONID
    //  리턴한 내용이 Authenticaiton 의 내용에 들어감

    var member = new CustomUser(
        user.getUsername(),
        user.getPassword(),
        user.isEnabled(),
        true,
        true,
        true, Authoritys);
    member.displayName = "소마";
    return member;
  }

}

// custom 속성 추가 위한 class
// **쿠키를 지워야 적용될수있음
class CustomUser extends User {

  public String displayName;

  public CustomUser(String username, String password, boolean enabled,
      boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked,
      Collection<? extends GrantedAuthority> authorities) {
    // 기존 class constructor
    super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked,
        authorities);


  }
}