package app.Config;

import app.Service.MemberService;
import app.Service.OauthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration // 설정 클래스설정 => 안하면 기본값이 들어감
@EnableWebSecurity // 시큐리티
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // 스프링 시큐리티[보안 솔루션]
    // 1. 웹 페이지 접근시 시큐리티 로그인 페이지 실행[콘솔에 pw확인]
    // 2. 읽기,쓰기,삭제 불가 => CSRF


    // p. 150
    @Autowired
    public PasswordEncoder passwordEncoder() { // pw 암호화 관련 클래스
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception { // 웹 URL 접근 보안
        //  super.configure(http); 직접 입력할거라 사용X
        http.authorizeRequests() // URL 인증요청
                .antMatchers("/**").permitAll() // .antMatchers("/**").permitAll(); : 모든 권한이 접근 가능
                .and()
                .csrf()// 사이트간 요청위조 설정
                .ignoringAntMatchers("/**") // ignoringAntMatchers("url") : 요청 위조 보안 제외할 url
                .and()
//                .formLogin() //로그인페이지 보안설정
//                .loginPage("/member/login") // 아이디/비밀번호를 입력받을 페이지 url
//                .defaultSuccessUrl("/") // 로그인 성공시 이동할 url
//                .usernameParameter("memberId") // 시큐리티 로그인[아이디] 기본값은 :username => mid로 변수명 사용
//                .passwordParameter("memberPw") // 시큐리티 로그인[password] 기본값은 : password => m_pw로 변수명 사용
                // .permitAll() 로그인은 모든 권한이 접근 가능
                //.and()
                .logout() // 로그아웃 관련 설정
                .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout")) // 로그아웃 설정
                .logoutSuccessUrl("/") // 로그아웃 성공시 이동할 url
                .invalidateHttpSession(true) // 세션 초기화
                .and()
                .oauth2Login() // oauth2 로그인 설정
                .userInfoEndpoint()
                .userService(oauthService); // oauth2 서비스

    }
    @Autowired
    private OauthService oauthService;

    @Override
    public void configure(WebSecurity web) throws Exception { // 웹 리소스 접근 보안
        super.configure(web);

    }
    @Autowired
    private MemberService memberService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {  // 인증 관련 보안

        auth.userDetailsService(memberService).passwordEncoder( passwordEncoder());

    }


}