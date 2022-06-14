package app.Service;


import app.Entity.MemberEntity;
import app.Repository.MemberRepository;
import app.dto.OauthDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Map;

@Service
public class OauthService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    @Override // 소셜 로그인후 회원정보 가져오기 메소드
    public OAuth2User loadUser(OAuth2UserRequest userRequest ) throws OAuth2AuthenticationException {

        OAuth2UserService oAuth2UserService = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = oAuth2UserService.loadUser( userRequest );  // perperties 에 요청 uri로부터  인증,토큰,회원정보 등등

        // 회원정보 속성 가져오기
        String nameattributekey = userRequest.getClientRegistration()
                .getProviderDetails()
                .getUserInfoEndpoint()
                .getUserNameAttributeName();

        // 클라이언트 아이디 가져오기
        String registrationid = userRequest.getClientRegistration().getRegistrationId();

        System.out.println(   registrationid  );
        System.out.println(   nameattributekey  );
        System.out.println(   oAuth2User.getAttributes()  );

        // DTO
        OauthDto oauth2Dto = OauthDto.of( registrationid , nameattributekey  , oAuth2User.getAttributes() );

        // oauth2Dto -> entitiy

        System.out.println( oauth2Dto.toentity()   );
        //
        memberRepository.save(  oauth2Dto.toentity()   );

        // 리턴 ( 회원정보와 권한[키] )
        return null;
    }

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private MemberRepository memberRepository;




    // 동일한 이메일이 있을경우 업데이트 동일한 이메일 없으면 저장
    public MemberEntity saveorupdate(  OauthDto oauth2Dto ){

        // 1. memberRepository 이용한 동일한 이메일찾기. [ findBy필드명 -> 반환타입 : Optional
        MemberEntity memberEntity = memberRepository.findBymemberEmail( oauth2Dto.toentity().getMemberEmail() )
                .map( entity -> entity.update( oauth2Dto.toentity().getMemberName() ) )
                // map( 임시객체명 => 임시객체명.메소드) : 동일한 이메일이 있을 경우 => 특정 이벤트 수정
                .orElse( oauth2Dto.toentity() );    // orElse(  )  : 동일한 이메일이 없을경우 dto->entity

        // Optional클래스 사용을 안할 경우
        //if(memberEntity != null) memberEntity.update(oauth2Dto.getName());
        // else if(memberEntity == null) memberEntity = oauth2Dto.toentity();

        // Optional 클래스
        // 1. orElse( 해당 Optional객체 null 이면 ) 값이 없을경우
        // 2. map ( Optional객체 -> 메소드  ) : 여러개 있을경우 모두 처리 / 값이 있는경우

        return memberRepository.save( memberEntity );
    }


}