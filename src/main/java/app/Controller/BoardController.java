package app.Controller;

import app.Entity.BoardEntity;
import app.Service.BoardService;
import app.dto.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/boardList")
    public ResponseEntity<Map> board_list(@RequestParam(value = "p_num", required=false) Integer p_num) {
        if (p_num == null || p_num <= 0) {
            p_num = 1;
        }
        return  boardService.getboard(p_num);
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