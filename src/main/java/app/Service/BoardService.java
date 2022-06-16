package app.Service;

import app.Entity.BoardEntity;
import app.Entity.CategoryEntity;
import app.Exception.ResourceNotFoundException;
import app.Repository.BoardRepository;
import app.Repository.CategoryRepository;
import app.dto.BoardDto;
import app.util.PagingUtil;
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


//    @Transactional
//    public List<BoardEntity> get() {
//
//        System.out.println("게시판 메소드 실행");
//        List<BoardEntity> b_list = boardRepository.findAll();
//        return b_list;
//    }

    @Transactional
    public int findAllCount() {
        return (int) boardRepository.count();
    }

    @Transactional
    public ResponseEntity<Map> getboard(Integer p_num) {
        Map result = null;

        PagingUtil pu = new PagingUtil(p_num, 4, 5); // ($1:표시할 현재 페이지, $2:한페이지에 표시할 글 수, $3:한 페이지에 표시할 페이지 버튼의 수 )
        List<BoardEntity> list = boardRepository.findFromTo(pu.getObjectStartNum(), pu.getObjectCountPerPage());
        pu.setObjectCountTotal(findAllCount());
        pu.setCalcForPaging();


        if (list == null || list.size() == 0) {
            return null;
        }

        result = new HashMap<>();
        result.put("pagingData", pu);
        result.put("list", list);

        return ResponseEntity.ok(result);
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