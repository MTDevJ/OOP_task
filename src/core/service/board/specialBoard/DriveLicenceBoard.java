package core.service.board.specialBoard;

import core.service.board.BoardType;
import core.service.board.Board;

import java.util.ArrayList;

public class DriveLicenceBoard extends Board {

    public DriveLicenceBoard() {
        analysis = new ArrayList<>();
        examinations = new ArrayList<>();
        this.TYPE = BoardType.DRIVE_LICENCE;
    }

}
