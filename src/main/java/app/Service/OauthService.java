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
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2UserService oAuth2UserService = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = oAuth2UserService.loadUser( userRequest );  // perperties 에 요청 uri로부터  인증,토큰,회원정보 등등

        // 회원정보 속성 가져오기
        String nameattributekey = userRequest.getClientRegistration()
                .getProviderDetails()
                .getUserInfoEndpoint()
                .getUserNameAttributeName();

        // 클라이언트 아이디 가져오기
        String registrationid = userRequest.getClientRegistration().getRegistrationId();

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


}
