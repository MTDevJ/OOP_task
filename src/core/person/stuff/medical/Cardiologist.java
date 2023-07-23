package core.person.stuff.medical;

import core.service.examination.HeartCheck;

public class Cardiologist extends MedicalStaff {

    private final DoctorType TYPE = DoctorType.CARDIOLOGIST;

    public Cardiologist() {
        super();
        supportedExamination.add(HeartCheck.class);
    }

    @Override
    public DoctorType getType() {
        return TYPE;
    }
}
