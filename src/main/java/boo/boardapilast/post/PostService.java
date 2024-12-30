package boo.boardapilast.post;

import boo.boardapilast.board.Board;
import boo.boardapilast.board.BoardRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    BoardRepository boardRepository;
    PostRepository postRepository;

    public PostService(PostRepository postRepository, BoardRepository boardRepository) {
        this.postRepository = postRepository;
        this.boardRepository = boardRepository;
    }

    public void create(@Valid CreatePostRequest request) {
        Board board = boardRepository.findById(request.boardid()).orElseThrow();
        postRepository.save(new Post(
                request.title(),
                request.content(),
                board)
        );

    }

    public PostResponse choiceid(Long id) {
        //Todo Long id(게시글의 id ) 를 입력받고 CreatePostRespose형태의 리스트를 반환하는 메서드
        //그러면 PostRespository 의 findbyid 로 Long id 를 받은뒤에
//        return postRepository.findById(id).stream()
//                .map(list -> new PostResponse(
//                        list.getTitle(),
//                        list.getContent()))
//                .toList();
        Post post = postRepository.findById(id).orElseThrow();
        return new PostResponse(
                post.getTitle(),
                post.getContent()
                //Todo 한개면 굳이 map 쓸 필요 없음.
        );
        /*
        * {
        *     "title": "",
        *     "content": ""
        * }
        * */
    }
}
