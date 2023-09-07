package core.person.stuff.medical;

import core.person.Patient;
import core.service.examination.RegularCheck;

public class Therapist extends MedicalStaff {

    private final DoctorType TYPE = DoctorType.THERAPIST;
    public Therapist() {
        super();
        supportedExamination.add(RegularCheck.class);
    }
    @Override
    public DoctorType getType() {
        return TYPE;
    }

    @Override
    public String doAppointment(Patient patient) {
        if (patient.getClient().getAge() < 60) return "all is good";
        return "you are sick";
    }
}
