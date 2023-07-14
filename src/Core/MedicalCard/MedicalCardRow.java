package Core.MedicalCard;

import Core.Person.Patient;
import Core.Person.Stuff.Staff;

import java.sql.Date;

public class MedicalCardRow {
   /* String diagnosis; // diagnosis = "Healthy";
    List<Analysis> analysisList;

    List<Result> results;

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public ArrayList<Board> getBoards() {
        return boards;
    }

    public void setBoard(Board board) {
        this.boards.add(board);
    }*/

    Patient patient;
    Staff cratedBy;
    Date date;

    public MedicalCardRow(Staff cratedBy, Patient patient) {
        this.patient = patient;
        this.cratedBy = cratedBy;
        this.date = new Date(System.currentTimeMillis());
    }
}
