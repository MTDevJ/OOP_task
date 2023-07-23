package core.medicalCard;

import core.person.client.Client;
import core.person.stuff.management.ManagementStaff;

import java.util.ArrayList;
import java.util.Date;

public class MedicalCard implements MedicalCardInterface{

    private static MedicalCard medicalCardInstance;

    private ArrayList<MedicalCardRecord> medicalCardRecords;
    private Client patient;

    private Date createdDate;
    private ManagementStaff createdBy;

    private MedicalCard() {
        createdDate = new Date(System.currentTimeMillis());
        medicalCardRecords = new ArrayList<MedicalCardRecord>();
    }

    private MedicalCard(ManagementStaff administrator, Client patient) {
        this();
        this.patient = patient;
        this.createdBy = administrator;
    }

    public static MedicalCard getMedicalCardInstance(ManagementStaff person, Client patient){
        if (medicalCardInstance == null) return new MedicalCard(person, patient);
        return medicalCardInstance;
    }

    public Client getPatient() {
        return patient;
    }

    public void setPatient(Client patient) {
        this.patient = patient;
    }

    @Override
    public void addRecord(MedicalCardRecord record) {
        medicalCardRecords.add(record);
    }

    public void print(){
        System.out.println("***"+patient.getName() + "'s Medical card***");
        medicalCardRecords.forEach(record -> System.out.println("--|" + " Appointment Result: " + record.getAppointmentResult().getDiagnosis()
                + "| Created by:" + record.getCratedBy().getName() + "| Date:" + record.getDate()));
        System.out.println("Created data: " + createdDate);
        System.out.println("Created by: " + createdBy.getName());
        System.out.println();
    }
}
