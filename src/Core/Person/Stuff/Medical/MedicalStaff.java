package Core.Person.Stuff.Medical;

import Core.Enums.DoctorType;
import Core.Person.Stuff.Staff;

public abstract class MedicalStaff extends Staff {

    public abstract DoctorType getType();
}
