package app.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {

    MASTER( "ROLE_MASTER","관리자" ) ,  SILVER("ROLE_SILVER" , "실버회원"),  GOLD("ROLE_GOLD" , "골드회원");
    // 생성자를 통한 key 와 title 할당
    private String key ;
    private String title ;

}