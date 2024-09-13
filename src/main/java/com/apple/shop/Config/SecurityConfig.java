package com.apple.shop.Config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

  private final UserDetailsService userDetailsService;
  private final PasswordEncoder passwordEncoder;


  @Bean
  // 특정페이지를 로그인요청할지 설정가능
  // 요청과 응답사이의 처리
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(authorize -> authorize

            .requestMatchers("/login", "/global.css", "/join", "/css/**")
            .permitAll() // 로그인 페이지와 정적 리소스 허용
            .anyRequest().authenticated() // 그 외의 모든 요청은 인증 필요
        )
        .formLogin(form -> form
            .loginPage("/login") // 사용자 정의 로그인 페이지 설정
            .defaultSuccessUrl("/login", true) // 로그인 성공 후 이동할 페이지 설정
            .permitAll() // 로그인 페이지 접근 허용
        )
        .logout(logout -> logout
            .logoutUrl("/logout") // 로그아웃 URL 설정
            .logoutSuccessUrl("/login?logout") // 로그아웃 후 리다이렉트할 페이지 설정
            .permitAll()
        )
        .csrf(csrf -> csrf.disable())
        .userDetailsService(userDetailsService); // CSRF 보호 비활성화 (개발 환경에서만 사용)
    return http.build();
  }

  // In-Memory 사용자 설정
  @Bean
  public UserDetailsService userDetailsService() {
    UserDetails user = User.withDefaultPasswordEncoder()
        .username("tomato") // 초기 사용자 이름
        .password("1111") // 초기 사용자 비밀번호
        .roles("USER") // 사용자 역할
        .build();
    return new InMemoryUserDetailsManager(user);
  }

}
