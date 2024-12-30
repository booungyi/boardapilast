package boo.boardapilast.board;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    private BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
            this.boardRepository = boardRepository;
    }

    public List<BoardResponse> findALL() {
        List<Board> boards = boardRepository.findAll();
        return boards.stream()
                .map(board -> new BoardResponse(
                        board.getId()
                , board.getName()))
                .toList();
    }

    public void create(CreateBoardRequest request) {
        boardRepository.save(new Board(request.name()));
    }

    public void delet(Long id) {
        boardRepository.deleteById(id);
    }

    //수정방법 -> id  와 name 을 넣음
    public void put(Long id, CreateBoardRequest name) {
        Board board = boardRepository.findById(id).orElseThrow();
        board.setName(name.name());
        boardRepository.save(board);
    }
}
