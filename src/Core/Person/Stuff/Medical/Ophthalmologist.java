package Core.Person.Stuff.Medical;

import Core.Enums.DoctorType;

public class Ophthalmologist extends MedicalStaff {

    //TODO supported services
    private final DoctorType TYPE = DoctorType.OPHTHALMOLOGIST;

    public DoctorType getType() {
        return TYPE;
    }
}
