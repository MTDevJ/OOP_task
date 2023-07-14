package Core.Person.Stuff.Medical;

import Core.Enums.DoctorType;

public class Therapist extends MedicalStaff {

    //TODO supported procedure\tests\analysis
    private final DoctorType TYPE = DoctorType.THERAPIST;

    @Override
    public DoctorType getType() {
        return TYPE;
    }
}
