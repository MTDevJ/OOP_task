package Core;

import Core.Enums.BoardType;
import Core.Person.Patient;

public class PatientRequest {

    BoardType type;

    public PatientRequest(BoardType type) {
        this.type = type;
    }

    public BoardType getType() {
        return type;
    }
}
