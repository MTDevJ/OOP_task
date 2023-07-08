package Core.Person.Stuff.Management;

import Core.Enums.DoctorType;

public class Administrator extends ManagementStaff {

    private final DoctorType TYPE = DoctorType.THERAPIST;

    @Override
    public DoctorType getType() {
        return TYPE;
    }
}
