package app.Controller;

import app.Service.BoardService;
import app.dto.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BoardController {


    @Autowired
    BoardService boardService;
    @Autowired
    HttpServletRequest request;

    // 게시판 메인으로
    @GetMapping("/Board/BoardList")
    public String goToBoardMain(Model model) {
      //  List<CategoryDto> categoryDTOS = boardService.CreateCategory();

      //  model.addAttribute("categoryDTOS", categoryDTOS);
        return "Board/BoardList";
    }

    // 글쓰기 페이지 열기
    @GetMapping("/Board/BoardWrite")
    public String goToBoardWrite() {
        return "Board/BoardWrite";
    }


    // 글쓰기
    @GetMapping("/Board/BoardW") @ResponseBody
    public String BoardWrite(@RequestParam("title")String title, @RequestParam("contents")String contents) {
        HttpSession session = request.getSession();
       // boolean result = boardService.BoardWrite(title, contents, type);
        //if(result) {
       //     return "1";
       // } else {
       //     return "0";
      //  }
        return null;
    }


}
