package app.dto;

import app.Entity.MemberEntity;
import lombok.Getter;


public class IntergratedDto{
       /* implements UserDetails{*/

   /* private int mnum;
    private String mid;
    private String m_pw;
    private final Set<GrantedAuthority> authorities; // 인증
    // dto 생성자
    public IntergratedDto(MemberEntity memberEntity,
                          Collection< ? extends GrantedAuthority> authorities) {
        this.mid = memberEntity.getMid();
        this.m_pw = memberEntity.getM_pw();
        this.mnum = memberEntity.getM_num();
        this.authorities = Collections.unmodifiableSet(new LinkedHashSet<>(authorities));
    }

    @Override // 회원의 패스워드를 반환하는 메소드
    public String getPassword() {
        return this.m_pw;
    }

    @Override // 회원의 id반환 메소드
    public String getUsername() {
        return this.mid;
    }

    @Override // 계정이 만료여부확인[true면 만료되지 않음] => false로 휴면계정으로 바뀔수 있음
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override // 계정이 잠겨 있는지 확인[true면 잠겨있지 않음]
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override // 계정의 패스워드가 만료여부 확인[true면 만료되지 않음]
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override // 계정이 사용가능한 계정인지 확인[true면 사용가능]
    public boolean isEnabled() {
        return true;
    }*/

}
