package boo.boardapilast.board;

import jakarta.validation.constraints.Size;

public record CreateBoardRequest(
        @Size(max = 20) String name
) {
}
