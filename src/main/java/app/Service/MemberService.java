package app.Service;

import app.Entity.MemberEntity;
import app.Repository.MemberRepository;

import app.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
   /* @Service
    public class MemberService implements UserDetailsService {
*/
    @Autowired // 자동 메모리 할당
    MemberRepository memberRepository;

/*
    // 회원등록메소드
    public boolean membersignup(MemberDto memberDto){

        // pw암호화
        // 1. 암호화 클래스 객체생성
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // 2. 입력받은 memberDto 내 pw 재설정[암호화객체명.encode(입력받은 패스워드)]
        memberDto.setMemberPw(passwordEncoder.encode(memberDto.getMemberPw()));

        memberRepository.save(memberDto.toentity());// Entity를 DB에 저장
        // save(entity) : insert / update
        return true;
    }
*/



    // 회원번호 -> 회원정보 반환[비밀번호 제외]
    public MemberDto getMemberDto(int memberNo) {
        // findById(기본키[pk키]) : 해당 pk값의 엔티티 호출
        // 1. 해당 회원번호[pk]만 엔티티 호출
        Optional<MemberEntity> entityOptional = memberRepository.findById(memberNo);
        // 2. 찾은 엔티티를 dto로 변경 후 반환
        return MemberDto.builder()
                .memberId(entityOptional.get().getMemberId())
                .memberName(entityOptional.get().getMemberName())
                .memberPhone(entityOptional.get().getMemberPhone())
                .memberGender(entityOptional.get().getMemberGender())
                .memberPoint(entityOptional.get().getMemberPoint())
                .memberEmail(entityOptional.get().getMemberEmail())
                .build();
    }

    @Autowired
    private HttpServletRequest request;

    // 회원번호 => 회원엔티티 반환 => room 관련 서비스
    public MemberEntity getMemberEntity(int memberNo){
        Optional<MemberEntity> entityOptional = memberRepository.findById(memberNo);
        return entityOptional.get();
    }
/*

    @Override   // /member/logincontroller URL 호출시 실행되는 메소드 [ 로그인처리(인증처리) 메소드 ]
    public UserDetails loadUserByUsername(String memberId ) throws UsernameNotFoundException {

        // 회원 아이디로 회원엔티티 찾기
        Optional<MemberEntity> entityOptional = memberRepository.findBymemberId( memberId );
        MemberEntity memberEntity = entityOptional.orElse(null);
        //   .orElse( null ) : 만약에 엔티티가 없으면 null

        // 찾은 회원엔티티의 권한[키] 을 리스트에 담기
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add( new SimpleGrantedAuthority( memberEntity.getRolekey() ) ) ;
        // GrantedAuthority : 권한 [ 키 저장 가능한 클래스 ]

        // 세션 부여
        MemberDto loginDto =   MemberDto.builder().memberId(memberEntity.getMemberId()).memberNo( memberEntity.getMemberNo() ).build();
        HttpSession session = request.getSession();   // 서버내 세션 가져오기
        session.setAttribute( "logindto" , loginDto );    // 세션 설정

        // 회원정보와 권한을 갖는 UserDetails 반환
        return new IntergratedDto( memberEntity , authorities );
    }
*/



}
