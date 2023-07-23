package core.journal;

import core.appointment.Appointment;
import core.person.Person;
import core.person.stuff.management.ManagementStaff;

import java.sql.Date;

public class JournalRecord {

    Person person;
    JournalRecordType type;
    Date registrationdate;
    ManagementStaff createdBy;
    Appointment appointment;

    public JournalRecord() {
        this.registrationdate = new Date(System.currentTimeMillis());
    }

    public JournalRecord(ManagementStaff staff, Person person, JournalRecordType type) {
        this();
        this.person = person;
        this.createdBy = staff;
        this.type = type;
    }

    public JournalRecord(ManagementStaff staff, Person person, Appointment appointment, JournalRecordType type) {
        this(staff, person, type);
        this.appointment = appointment;
    }

    public Person getPatient() {
        return person;
    }

    public void setPatient(Person person) {
        this.person = person;
    }

}
