package core.medicalCard;

import core.appointment.AppointmentResult;
import core.person.stuff.medical.MedicalStaff;

import java.sql.Date;

public class MedicalCardRecord {
    MedicalStaff cratedBy;
    Date date;

    AppointmentResult appointmentResult;
    //TODO String resolution; ?

    public MedicalCardRecord(MedicalStaff cratedBy, AppointmentResult appointmentResult) {
        this.cratedBy = cratedBy;
        this.date = new Date(System.currentTimeMillis());
        this.appointmentResult = appointmentResult;
    }

    public MedicalStaff getCratedBy() {
        return cratedBy;
    }

    public Date getDate() {
        return date;
    }

    public AppointmentResult getAppointmentResult() {
        return appointmentResult;
    }

}
