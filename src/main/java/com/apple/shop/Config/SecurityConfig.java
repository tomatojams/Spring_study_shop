package com.apple.shop.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(authorize -> authorize
            .requestMatchers("/login", "/global.css", "/css/**").permitAll() // 로그인 페이지와 정적 리소스 허용
            .anyRequest().authenticated() // 그 외의 모든 요청은 인증 필요
        )
        .formLogin(form -> form
            .loginPage("/login") // 사용자 정의 로그인 페이지 설정
            .defaultSuccessUrl("/home", true) // 로그인 성공 후 이동할 페이지 설정
            .permitAll() // 로그인 페이지 접근 허용
        )
        .logout(logout -> logout
            .logoutUrl("/logout") // 로그아웃 URL 설정
            .logoutSuccessUrl("/login?logout") // 로그아웃 후 리다이렉트할 페이지 설정
            .permitAll()
        )
        .csrf(csrf -> csrf.disable()); // CSRF 보호 비활성화 (개발 환경에서만 사용)
    return http.build();
  }

  // In-Memory 사용자 설정
  @Bean
  public UserDetailsService userDetailsService() {
    UserDetails user = User.withDefaultPasswordEncoder()
        .username("tomato") // 초기 사용자 이름
        .password("7777") // 초기 사용자 비밀번호
        .roles("USER") // 사용자 역할
        .build();
    return new InMemoryUserDetailsManager(user);
  }

}
