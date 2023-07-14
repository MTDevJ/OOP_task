package Core.Journal;

import Core.Person.Patient;
import Core.Person.Stuff.Staff;

import java.sql.Date;

public class JournalRow {

    Patient patient;
    Date registrationdate;
    Staff createdBy;

    public JournalRow(Staff person, Patient patient) {
        this.patient = patient;
        this.createdBy = person;
        this.registrationdate = new Date(System.currentTimeMillis());
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getRegistrationdate() {
        return registrationdate;
    }

    public void setRegistrationDate(Date registrationdate) {
        this.registrationdate = registrationdate;
    }
}
