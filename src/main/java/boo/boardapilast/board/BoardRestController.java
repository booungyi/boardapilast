package boo.boardapilast.board;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// BoardService boardService = new BoardService()
// new BoardRestController(boardService);

@RestController
public class BoardRestController {

    BoardService boardService;

    public BoardRestController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping("/boards")
    public void create(@Valid @RequestBody CreateBoardRequest request) {
        boardService.create(request);
    }

    @GetMapping("/boards")
    public List<BoardResponse> findALL() {
        return boardService.findALL();
    }

    @DeleteMapping("/boards")
    public void delet(@Valid @RequestBody Board id) {
        boardService.delet(id.getId()); // 성공인데? 왜지???????????????????????
    }

    @PutMapping("/boards/{id}")
    public void put(@Valid@PathVariable Long id ,@Valid @RequestBody CreateBoardRequest request) {
        boardService.put(id,request);
    }
}
