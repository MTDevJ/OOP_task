package core.person.stuff.medical.strategy;

import core.person.Patient;

public class TherapistAppointmentStrategy implements MedicalAppointmentStrategy{

    @Override
    public String doAppointment(Patient patient) {
        if (patient.getClient().getAge() < 60) return "all is good";
        return "you are sick";
    }
}
