package boo.boardapilast.board;

import boo.boardapilast.post.Post;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Board() {
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "board")
    private List<Post> posts;

    // 생성자, getter, setter 등
    public Board(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Post> getPosts() {
        return posts;
    }
}
