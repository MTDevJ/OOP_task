package core.person;

import core.appointment.AppointmentList;
import core.medicalCard.MedicalCard;
import core.person.client.Client;
import core.service.analysis.Analysis;
import core.service.examination.Examination;

import java.util.List;


public class Patient extends Person{
    Client client;
    List<AppointmentList> appointmentList;
    MedicalCard medicalCard;

    public Patient(Client client, MedicalCard medicalCard) {
        this.medicalCard = medicalCard;
        this.client = client;
    }

    public List<AppointmentList> getAppointmentList() {
        return appointmentList;
    }

    public MedicalCard getMedicalCard() {
        return medicalCard;
    }

    public void setAppointmentList(List<AppointmentList> appointmentList) {
        this.appointmentList = appointmentList;
    }

    public Client getClient() {
        return client;
    }

    public void printAppointmentList(){
        System.out.println("***Appointment list***");
        System.out.println("-Patient: " + client.getName());
        System.out.println("-Analysis:");
        this.appointmentList.stream().filter(item -> item.getMedicalService() instanceof Analysis)
                .forEach(item -> System.out.println(" -|" + item.getMedicalService().getClass().getName().substring(item.getMedicalService().getClass().getName().lastIndexOf('.')+1) + ";"));
        System.out.println("-Examination:");
        this.appointmentList.stream().filter(item -> item.getMedicalService() instanceof Examination)
                .forEach(item -> System.out.println(" -|" + item.getMedicalService().getClass().getName().substring(item.getMedicalService().getClass().getName().lastIndexOf('.')+1) + ";"));
        System.out.println();
    }
}
