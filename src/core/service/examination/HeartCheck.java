package core.service.examination;

import core.person.stuff.medical.DoctorType;

public class HeartCheck extends Examination{

    public HeartCheck() {
        doctorType = DoctorType.CARDIOLOGIST;
        appointmentDuration = 1000;
    }
}
