package app.dto;

import app.Entity.MemberEntity;
import app.Entity.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;


public class OauthDto {
   // 닉네임
    String name;
    // 이메일
    String email;

    String age;

    String mobile;

    String gender;


    // 회원정보
    private Map<String,Object> attribute;
    // 요청 토큰[키]
    private String nameattributekey;

    // 풀생성자
    @Builder
    public OauthDto(String name, String email, String age, String mobile, String gender, Map<String, Object> attribute, String nameattributekey) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.mobile = mobile;
        this.gender = gender;
        this.attribute = attribute;
        this.nameattributekey = nameattributekey;
    }

    // 클라이언트 구분용[카카오 or 네이버 or 구글]
    public static OauthDto of(String registrationid, String nameattributekey, Map<String, Object> attribute){
        if(registrationid.equals("naver")){
            return ofnaver(nameattributekey, attribute);
        } else{
            return ofnaver(nameattributekey, attribute);
        }

    }
    // 네이버 정보 dto 변환 메소드
    private static OauthDto ofnaver(String nameattributekey, Map<String, Object> attribute){
        Map<String, Object> response = (Map<String, Object>) attribute.get("response");
        return OauthDto.builder()
                .name((String) response.get("name"))
                .email((String) response.get("email"))
                .age( (String)  response.get("age"))
                .mobile((String)  response.get("mobile"))
                .gender((String) response.get("gender"))
                .attribute(attribute)
                .nameattributekey((String)response.get("id"))
                .build();
    }
    // 첫 로그인시 회원가입 dto => entity변환 => DB
    public MemberEntity toentity(){
        return MemberEntity.builder()
                .memberName(this.name)
                .memberEmail(this.email)
                .memberAge(this.age)
                .memberPhone(this.mobile)
                .memberGender(this.gender)
                .memberGrade(Role.MASTER)
                .memberId(email.split("@")[0])
                .memberToken(this.nameattributekey)
                .build();
    }

}
