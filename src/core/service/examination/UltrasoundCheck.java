package core.service.examination;

import core.person.stuff.medical.DoctorType;

public class UltrasoundCheck extends Examination{

    public UltrasoundCheck() {
        doctorType = DoctorType.ULTRASOUND_DOCTOR;
        appointmentDuration = 30000;
        price = 20;
    }
}
