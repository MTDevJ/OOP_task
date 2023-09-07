package core.service.board.specialBoard;

import core.service.analysis.Analysis;
import core.service.board.Board;
import core.service.board.BoardType;
import core.service.examination.Examination;

import java.util.ArrayList;

public class OtherBoard extends Board {

    public OtherBoard() {
        analysis = new ArrayList<Analysis>();
        examinations = new ArrayList<Examination>();
        TYPE = BoardType.OTHER;
    }

}
