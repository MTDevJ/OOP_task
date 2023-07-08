package Core.MedicalCard;

import Core.Person.Patient;
import Core.Person.Stuff.Management.Administrator;
import Core.Service.Board.Board;

import java.util.ArrayList;
import java.util.Date;

public class MedicalCard {

    private MedicalCard medicalCardInstance;
    private Patient patient;
    private String diagnosis;

    private ArrayList<Board> boards;

    //TODo private ArrayList<BoardResult> boardResults;

    private Date createdDate;
    private Administrator createdBy;

    private MedicalCard() {
        boards = new ArrayList<>();
        diagnosis = "Healthy";
        createdDate = new Date();
    }

    public MedicalCard getMedicalCardInstance(){
        if (medicalCardInstance == null) return new MedicalCard();
        return medicalCardInstance;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public ArrayList<Board> getBoards() {
        return boards;
    }

    public void setBoard(Board board) {
        this.boards.add(board);
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
}
