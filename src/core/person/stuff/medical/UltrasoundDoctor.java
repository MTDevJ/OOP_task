package core.person.stuff.medical;

import core.person.Patient;
import core.service.examination.UltrasoundCheck;

public class UltrasoundDoctor extends MedicalStaff {

    private final DoctorType TYPE = DoctorType.ULTRASOUND_DOCTOR;

    public UltrasoundDoctor() {
        super();
        supportedExamination.add(UltrasoundCheck.class);
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
