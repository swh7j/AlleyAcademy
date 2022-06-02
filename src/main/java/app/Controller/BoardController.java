package app.Controller;

import app.Entity.BoardEntity;
import app.Service.BoardService;
import app.Service.CategoryService;
import app.dto.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/boardList")
    public List<BoardEntity> board_list() {
        List<BoardEntity> b_list = boardService.get();
        return b_list;
    }

    @PostMapping("/boardList")
    public BoardEntity createBoard(@RequestBody BoardDto boardDto  ) {
        return boardService.createBoard(boardDto);
    }

    @GetMapping("/boardList/{no}")
    public ResponseEntity<BoardEntity> getBoardByNo(
            @PathVariable Integer no) {

        return boardService.getBoard(no);
    }

    @PutMapping("/boardList/{no}")
    public ResponseEntity<BoardEntity> updateBoardByNo(
            @PathVariable Integer no, @RequestBody BoardEntity board){

        return boardService.updateBoard(no, board);
    }

    @DeleteMapping("/boardList/{no}")
    public ResponseEntity<Map<String, Boolean>> deleteBoardByNo(
            @PathVariable Integer no) {

        return boardService.deleteBoard(no);
    }
}
