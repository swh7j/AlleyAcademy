package app.Entity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity // 기본키 pk
@Table(name="member") // 테이블 속성
@Builder // 생성자의 안정성 보장
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MemberEntity extends BaseTimeEntity {




    @Id // Db내 테이블과 연결
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto key
    private int memberNo; // 회원번호

    @Column
    private String memberId;
    @Column
    private String memberPw;
    @Column
    private String memberName;
    @Column
    private String memberToken;
    @Column
    private String memberEmail;
    @Column
    private String memberAge;
    @Column
    private String memberPhone;
    @Column
    private String memberGender;
    @Column
    private int memberCondition;
    @Column
    private int memberPoint;


    @Enumerated(EnumType.STRING)
    @Column
    private Role memberGrade; // 회원등급

    public String getRolekey(){
        return this.memberGrade.getKey();
    }

    // oauth2에서 동일한 이메일이면 업데이트 처리 메소드
    public MemberEntity update(String name){
        this.memberName = name;
        return this;
    }


}
