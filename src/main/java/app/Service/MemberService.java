package app.Service;

import app.Entity.MemberEntity;
import app.Repository.MemberRepository;
import app.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
/*
@Service*/
public class MemberService {

    /*@Autowired // 자동 메모리 할당
    MemberRepository memberRepository;

    // 회원등록메소드
    public boolean membersignup(MemberDto memberDto){

        // pw암호화
        // 1. 암호화 클래스 객체생성
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // 2. 입력받은 memberDto 내 pw 재설정[암호화객체명.encode(입력받은 패스워드)]
        memberDto.setM_pw(passwordEncoder.encode(memberDto.getM_pw()));

        memberRepository.save(memberDto.toentity());// Entity를 DB에 저장
        // save(entity) : insert / update
        return true;
    }
    // 회원번호 -> 회원정보 반환[비밀번호 제외]
    public MemberDto getMemberDto(int m_num) {
        // findById(기본키[pk키]) : 해당 pk값의 엔티티 호출
        // 1. 해당 회원번호[pk]만 엔티티 호출
        Optional<MemberEntity> entityOptional = memberRepository.findById(m_num);
        // 2. 찾은 엔티티를 dto로 변경 후 반환
        return MemberDto.builder()
                .mid(entityOptional.get().getMid())
                .m_name(entityOptional.get().getM_names())
                .m_address(entityOptional.get().getM_address())
                .m_grade(entityOptional.get().getM_grade())
                .m_phone(entityOptional.get().getM_phone())
                .m_sex(entityOptional.get().getM_sex())
                .m_point(entityOptional.get().getM_point())
                .memail(entityOptional.get().getMemail())
                .m_createdDate(entityOptional.get().getCreatedDate()).build();
    }
*/


}
