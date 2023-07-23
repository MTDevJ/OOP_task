package core.person.stuff.medical;

import core.service.examination.EyesCheck;

public class Ophthalmologist extends MedicalStaff {

    private final DoctorType TYPE = DoctorType.OPHTHALMOLOGIST;

    public Ophthalmologist() {
        super();
        supportedExamination.add(EyesCheck.class);
    }

    public DoctorType getType() {
        return TYPE;
    }
}
