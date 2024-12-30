package boo.boardapilast.post;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostRestController {
    PostService postService;

    public PostRestController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("post")
    public void createpost(@Valid @RequestBody CreatePostRequest request) {
        postService.create(request);
    }

    @GetMapping("post/{id}")
    public PostResponse choicepostid(@PathVariable Long id) {
        return postService.choiceid(id);
    }

}


