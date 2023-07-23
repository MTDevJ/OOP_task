package core.person.stuff.medical;

import core.service.examination.HeartCheck;

public class Therapist extends MedicalStaff {

    private final DoctorType TYPE = DoctorType.THERAPIST;


    public Therapist() {
        super();
        supportedExamination.add(HeartCheck.class);
    }
    @Override
    public DoctorType getType() {
        return TYPE;
    }
}
