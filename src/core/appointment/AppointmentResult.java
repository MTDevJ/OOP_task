package core.appointment;

public class AppointmentResult {

    Appointment appointment;
    String diagnosis ="Healthy";

    public AppointmentResult(Appointment appointment, String diagnosis) {
        this.appointment = appointment;
        this.diagnosis = diagnosis;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public String getDiagnosis() {
        return diagnosis;
    }
}
