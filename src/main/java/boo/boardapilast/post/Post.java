package boo.boardapilast.post;

import boo.boardapilast.board.Board;
import boo.boardapilast.comment.Comment;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    // 생성자, getter, setter 등

    public Post() {
    }

    public Post(String title, String content, Board board) {
        this.title = title;
        this.content = content;
        this.board = board;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Board getBoard() {
        return board;
    }

    public List<Comment> getComments() {
        return comments;
    }
}
