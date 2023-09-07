package core.person.stuff.management;

import core.MedicalCenter;

public class Administrator extends ManagementStaff {

    private final ManagementType TYPE = ManagementType.ADMINISTRATOR;

    public Administrator(MedicalCenter medicalCenter) {
        super(medicalCenter);
    }

    @Override
    public ManagementType getType() {
        return TYPE;
    }
}
