package core;

import core.person.Patient;
import core.person.stuff.medical.DoctorType;


public class MedicalDirection {

    Patient patient;

    DoctorType doctorType;

    public MedicalDirection(Patient patient, DoctorType doctorType) {
        this.patient = patient;
        this.doctorType = doctorType;
    }
}
