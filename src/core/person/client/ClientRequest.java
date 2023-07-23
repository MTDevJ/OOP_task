package core.person.client;

import core.service.board.BoardType;

public class ClientRequest {

    BoardType type;

    public ClientRequest(BoardType type) {
        this.type = type;
    }

    public BoardType getType() {
        return type;
    }
}
