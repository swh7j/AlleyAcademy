package app.Repository;

import app.Entity.CategoryEntity;
import app.Entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Integer>{

/*
//    // 엔티티 검색 findby필드명
   Optional<MemberEntity> findBymemberId(String memberId);
//    //이메일 검사
   Optional<MemberEntity> findBymemberEmail(String memberEmail);
*/


}
