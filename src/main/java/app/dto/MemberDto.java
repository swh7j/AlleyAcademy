package app.dto;
import app.Entity.MemberEntity;
import lombok.*;
import org.apache.catalina.Role;

import java.time.LocalDateTime;


@NoArgsConstructor // 빈생성자
@AllArgsConstructor // 풀생성자
@Getter // get 메소드
@Setter // set 메소드
@ToString // 객체정보 메소드
@Builder
public class MemberDto {


    private int memberNo;
    private String memberId;
    private String memberPw;
    private String memberName;
    private String memberToken;
    private String memberEmail;
    private String memberAge;
    private String memberPhone;
    private String memberGender;
    private int memberCondition;
    private int memberPoint;
    private Role memberGrade;


    public MemberEntity toentity(){
        return MemberEntity.builder()
                .memberId(this.memberId)
                .memberPw(this.memberPw)
                .memberName(this.memberName)
                .memberGender(this.memberGender)
                .memberPhone(this.memberPhone)
                .memberToken(this.memberToken)
                .memberEmail(this.memberEmail)
                .memberAge(this.memberAge)
                .memberPoint(this.memberPoint)
                .memberCondition(this.memberCondition)
                .memberGrade(app.Entity.Role.MASTER).build();


    }

}