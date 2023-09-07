package core.service.examination;

import core.person.stuff.medical.DoctorType;

public class PsychiatristCheck extends Examination{

    public PsychiatristCheck() {
        doctorType = DoctorType.PSYCHIATRIST;
        appointmentDuration = 20000;
        price = 45;
    }
}
