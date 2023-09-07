package core.service.board.specialBoard;

import core.service.board.BoardType;
import core.service.board.Board;

import java.util.ArrayList;

public class WeaponBoard extends Board {

    public WeaponBoard() {
        analysis = new ArrayList<>();
        examinations = new ArrayList<>();
        TYPE = BoardType.WEAPON;
    }
}
