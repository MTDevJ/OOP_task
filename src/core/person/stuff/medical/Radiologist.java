package core.person.stuff.medical;

import core.service.examination.XrayCheck;

public class Radiologist extends MedicalStaff {

    private final DoctorType TYPE = DoctorType.RADIOLOGIST;

    public Radiologist() {
        super();
        supportedExamination.add(XrayCheck.class);
    }

    @Override
    public DoctorType getType() {
        return TYPE;
    }
}
