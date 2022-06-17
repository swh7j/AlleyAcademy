package app.Controller;

import app.Service.MemberService;
import app.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MemberController {

    @Autowired // 자동 메모리 할당
    MemberService memberService;
    @Autowired
    HttpServletRequest request;

/*    @GetMapping("/member/login") // 로그인 페이지 연결
    public String login() {
        return "member/login";
    }

}*/
 /*   @GetMapping("/member/signup") // 회원가입 페이지 연결
    public String signup(){
        return "member/signup";
    }

    @PostMapping("/member/signupcontroller") // 회원가입 처리연결
    public String signupcontroller(MemberDto memberDto){

        memberService.membersignup(memberDto);
        return "redirect:/"; // 회원가입 성공시 메인 페이지로 매핑
    }*/


    @GetMapping("/member/login") // 로그인 페이지 연결
    public String login(){
        return "member/login";
    }

    @GetMapping("/member/signup") // 회원가입 페이지 연결
    public String signup(){
        return "member/signup";
    }


}
