package core.service.examination;

import core.person.stuff.medical.DoctorType;

public class EyesCheck extends Examination{

    public EyesCheck() {
        doctorType = DoctorType.OPHTHALMOLOGIST;
        appointmentDuration = 1000;
    }
}
