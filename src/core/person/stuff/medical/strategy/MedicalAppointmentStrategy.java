package core.person.stuff.medical.strategy;

import core.appointment.AppointmentResult;
import core.person.Patient;

public interface MedicalAppointmentStrategy {

    String doAppointment(Patient patient);
}
