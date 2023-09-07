package core.person.stuff.medical.decorators;

import core.person.Patient;
import core.person.stuff.medical.DoctorType;
import core.person.stuff.medical.MedicalStaff;

public class DoctorDecorator extends MedicalStaff {

    MedicalStaff staff;

    public DoctorDecorator(MedicalStaff staff) {
        this.staff = staff;
    }

    @Override
    public DoctorType getType() {
        return staff.getType();
    }

    @Override
    public String doAppointment(Patient patient) {
        return staff.doAppointment(patient);
    }
}
