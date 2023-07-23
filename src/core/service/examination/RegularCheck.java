package core.service.examination;

import core.person.stuff.medical.DoctorType;

public class RegularCheck extends Examination{

    public RegularCheck() {
        doctorType = DoctorType.THERAPIST;
        appointmentDuration = 1000;
    }
}
