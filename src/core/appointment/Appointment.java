package core.appointment;

import core.person.Patient;
import core.person.stuff.medical.MedicalStaff;

public class Appointment {

    Patient patient;
    MedicalStaff doctor;
    Integer appointmentDuration;

    public Appointment(Patient patient, MedicalStaff doctor, Integer appointmentDuration) {
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDuration = appointmentDuration;
    }

    public Patient getPatient() {
        return patient;
    }

    public MedicalStaff getDoctor() {
        return doctor;
    }

}
