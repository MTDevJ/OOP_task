package Core.MedicalCard;

import Core.Person.Patient;
import Core.Person.Stuff.Management.Administrator;
import Core.Person.Stuff.Staff;
import Core.Service.Board.Board;

import java.util.ArrayList;
import java.util.Date;

public class MedicalCard implements MedicalCardInterface{

    private static MedicalCard medicalCardInstance;

    private ArrayList<MedicalCardRow> medicalCardRows;
    private Patient patient;
    private ArrayList<Board> boards;

    private Date createdDate;
    private Administrator createdBy;

    private MedicalCard() {
        medicalCardRows = new ArrayList<MedicalCardRow>();
    }

    public static MedicalCard getMedicalCardInstance(){
        if (medicalCardInstance == null) return new MedicalCard();
        return medicalCardInstance;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public void addRow(Staff person, Patient patient) {
        medicalCardRows.add(new MedicalCardRow(person, patient));
    }
}
