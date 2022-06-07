package app.Service;

import app.Entity.MemberEntity;
import app.Repository.MemberRepository;
import app.dto.IntergratedDto;
import app.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Optional;
/*
@Service*/
public class OauthService {

/*
    @Autowired
    private HttpServletRequest request;


    @Override   // /member/logincontroller URL 호출시 실행되는 메소드 [ 로그인처리(인증처리) 메소드 ]
    public UserDetails loadUserByUsername(String mid ) throws UsernameNotFoundException {

        // 회원 아이디로 회원엔티티 찾기
        Optional<MemberEntity> entityOptional = memberRepository.findBymid( mid );
        MemberEntity memberEntity = entityOptional.orElse(null);
        //   .orElse( null ) : 만약에 엔티티가 없으면 null

        // 찾은 회원엔티티의 권한[키] 을 리스트에 담기
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add( new SimpleGrantedAuthority( memberEntity.getRolekey() ) ) ;
        // GrantedAuthority : 권한 [ 키 저장 가능한 클래스 ]

        // 세션 부여
        MemberDto loginDto =   MemberDto.builder().mid(memberEntity.getMid()).m_num( memberEntity.getM_num() ).build();
        HttpSession session = request.getSession();   // 서버내 세션 가져오기
        session.setAttribute( "logindto" , loginDto );    // 세션 설정

        // 회원정보와 권한을 갖는 UserDetails 반환
        return new IntergratedDto( memberEntity , authorities );
    }

    @Override // 소셜 로그인후 회원정보 가져오기 메소드
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2UserService oAuth2UserService = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = oAuth2UserService.loadUser( userRequest );  // perperties에 요청 uri로부터  인증, 토큰, 회원정보 등등

        // 회원정보 속성 가져오기
        String nameattributekey = userRequest.getClientRegistration()
                .getProviderDetails()
                .getUserInfoEndpoint()
                .getUserNameAttributeName();

        // 클라이언트 아이디 가져오기
        String registrationid = userRequest.getClientRegistration().getRegistrationId();

        // DTO
        OauthDto oauthDto = OauthDto.of( registrationid , nameattributekey  , oAuth2User.getAttributes() );
        // DB 저장
        MemberEntity memberEntity= saveorupdate(oauthDto);
        // 세션 할당
        // 소셜 로그인시 id가 없기 때문에 이메일에서 @뒤를 제거한 아이디를 세션에 담기
        String snsid = memberEntity.getMemail().split("@")[0];
        MemberDto loginDto =   MemberDto.builder().mid(snsid).m_num( memberEntity.getM_num() ).build();
        HttpSession session = request.getSession();   // 서버내 세션 가져오기
        session.setAttribute( "logindto" , loginDto );    // 세션 설정

        // 리턴 ( 회원정보와 권한[키] )
        return new DefaultOAuth2User(
                Collections.singleton( new SimpleGrantedAuthority(  memberEntity.getRolekey()  )) ,
                oauthDto.getAttribute() ,
                oauthDto.getNameattributekey()  );
    }

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private MemberRepository memberRepository;




    // 동일한 이메일이 있을경우 업데이트 동일한 이메일 없으면 저장
    public MemberEntity saveorupdate(  OauthDto oauthDto ){

        // 1. memberRepository 이용한 동일한 이메일찾기. [ findBy필드명 -> 반환타입 : Optional
        MemberEntity memberEntity = memberRepository.findBymemail( oauthDto.getEmail() )
                .map( entity -> entity.update( oauthDto.getName() ) )
                // map( 임시객체명 => 임시객체명.메소드) : 동일한 이메일이 있을 경우 => 특정 이벤트 수정
                .orElse( oauthDto.toentity() );    // orElse(  )  : 동일한 이메일이 없을경우 dto->entity

        // Optional클래스 사용을 안할 경우
        //if(memberEntity != null) memberEntity.update(oauth2Dto.getName());
        // else if(memberEntity == null) memberEntity = oauth2Dto.toentity();

        // Optional 클래스
        // 1. orElse( 해당 Optional객체 null 이면 ) 값이 없을경우
        // 2. map ( Optional객체 -> 메소드  ) : 여러개 있을경우 모두 처리 / 값이 있는경우

        return memberRepository.save( memberEntity );
    }
*/


}
