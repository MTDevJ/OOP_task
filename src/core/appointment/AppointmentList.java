package core.appointment;

import core.person.Patient;
import core.service.MedicalService;


public class AppointmentList {
    Patient patient;
    Appointment appointment;
    MedicalService medicalService;

    public AppointmentList(Patient patient, Appointment appointment, MedicalService medicalService) {
        this.patient = patient;
        this.appointment = appointment;
        this.medicalService = medicalService;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public MedicalService getMedicalService() {
        return medicalService;
    }

}
