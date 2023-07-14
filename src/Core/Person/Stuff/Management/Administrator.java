package Core.Person.Stuff.Management;

import Core.Enums.DoctorType;
import Core.Enums.ManagementType;

public class Administrator extends ManagementStaff {

    private final ManagementType TYPE = ManagementType.ADMINISTRATOR;

    @Override
    public ManagementType getType() {
        return TYPE;
    }
}
