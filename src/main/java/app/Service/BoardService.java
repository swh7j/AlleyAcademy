package app.Service;

import app.Entity.BoardEntity;
import app.Entity.CategoryEntity;
import app.Exception.ResourceNotFoundException;
import app.Repository.BoardRepository;
import app.Repository.CategoryRepository;
import app.dto.BoardDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@AllArgsConstructor
@Transactional
@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    @Transactional
    public List<BoardEntity> get() {

        System.out.println("게시판 메소드 실행");
        List<BoardEntity> b_list = boardRepository.findAll();
        return b_list;
    }

    public BoardEntity createBoard(BoardDto boardDto  ) {
        System.out.println( boardDto.toString() );
         Optional<CategoryEntity> categoryEntity  = categoryRepository.findById( boardDto.getCategoryNo() );

        BoardEntity entity = BoardEntity.builder()
                .boardTitle( boardDto.getBoardTitle())
                .boardContents( boardDto.getBoardContents())
                .memberNo(boardDto.getMemberNo())
                .categoryEntity( categoryEntity.get() )
                 .build();

        categoryEntity.get().getBoardList().add( entity   );


        return boardRepository.save(entity);
    }

    public ResponseEntity<BoardEntity> getBoard(Integer no) {
        BoardEntity board = boardRepository.findById(no)
                .orElseThrow(() -> new ResourceNotFoundException("Not exist Board Data by no : ["+no+"]"));
        return ResponseEntity.ok(board);
    }

    public ResponseEntity<BoardEntity> updateBoard(
            Integer no, BoardEntity updatedBoard) {
        BoardEntity board = boardRepository.findById(no)
                .orElseThrow(() -> new ResourceNotFoundException("Not exist Board Data by no : ["+no+"]"));
        board.setBoardTitle(updatedBoard.getBoardTitle());
        board.setBoardContents(updatedBoard.getBoardContents());



        BoardEntity endUpdatedBoard = boardRepository.save(board);
        return ResponseEntity.ok(endUpdatedBoard);
    }

    public ResponseEntity<Map<String, Boolean>> deleteBoard(
            Integer no) {
        BoardEntity board = boardRepository.findById(no)
                .orElseThrow(() -> new ResourceNotFoundException("Not exist Board Data by no : ["+no+"]"));

        boardRepository.delete(board);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted Board Data by id : ["+no+"]", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


}
