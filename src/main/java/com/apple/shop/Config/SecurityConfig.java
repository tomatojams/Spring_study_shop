package com.apple.shop.Config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.core.AuthorizationGrantType;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

  private final UserDetailsService userDetailsService;

  //비전 생성기능
  @Bean
  //class로 만들어진 객체를 return new object() 로 주입 하면 효율적
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  //보안 필터
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(authorize -> authorize
            .requestMatchers("/login", "/global.css", "/join", "/css/**")
            .permitAll() // 로그인 페이지와 정적 리소스 허용
            .anyRequest().authenticated() // 그 외의 모든 요청은 인증 필요
        )
        // 폼으로 로그인하며 login 페이지 만들고, /login POST, username, password 단어를 맞추면 자동 로그인
        .formLogin(formLogin -> formLogin
            .loginPage("/login") // 폼로그인 페이지 위치
            .defaultSuccessUrl("/login", true) // 로그인 성공 후 이동할 페이지 설정
            .permitAll() // 로그인 페이지 접근 허용
        )
        .oauth2Login(oauth2 -> oauth2
            .loginPage("/oauth2/authorization/google") // OAuth2 로그인 페이지 설정
            .defaultSuccessUrl("/login", true) // OAuth2 로그인 성공 후 이동할 페이지 설정
        )
        .logout(logout -> logout
            .logoutUrl("/logout") // 로그아웃 URL 설정
            .logoutSuccessUrl("/login?logout") // 로그아웃 후 리다이렉트할 페이지 설정
            .permitAll()
        )
        .csrf(csrf -> csrf.disable()) // CSRF 보호 비활성화 (개발 환경에서만 사용)
        .userDetailsService(userDetailsService); // UserDetailsService를 통한 DB 인증 설정

    return http.build();
  }

  // OAuth2 관련
  @Bean
  public ClientRegistrationRepository clientRegistrationRepository() {
    ClientRegistration clientRegistration = ClientRegistration.withRegistrationId("my-client")
        .clientId("your-client-id")
        .clientSecret("your-client-secret")
        .scope("scope1", "scope2")
        .authorizationUri("https://example.com/auth")
        .tokenUri("https://example.com/token")
        .redirectUri("{baseUrl}/login/oauth2/code/{registrationId}")
        .clientName("My Client")
        .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE) // 인증 방식 설정
        .build();

    return new InMemoryClientRegistrationRepository(clientRegistration);
  }
}
