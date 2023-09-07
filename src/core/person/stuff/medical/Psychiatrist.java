package core.person.stuff.medical;

import core.person.Patient;
import core.service.examination.PsychiatristCheck;

public class Psychiatrist extends MedicalStaff {

    private final DoctorType TYPE = DoctorType.PSYCHIATRIST;

    public Psychiatrist() {
        super();
        supportedExamination.add(PsychiatristCheck.class);
    }

    @Override
    public DoctorType getType() {
        return TYPE;
    }

    @Override
    public String doAppointment(Patient patient) {
        return null;
    }
}
