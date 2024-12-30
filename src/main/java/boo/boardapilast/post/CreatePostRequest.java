package boo.boardapilast.post;

import boo.boardapilast.board.Board;

public record CreatePostRequest(
        String title,
        String content,
        Long boardid

) {
}
