package core.service.analysis;

import core.person.stuff.medical.DoctorType;


public class BloodAnalysis extends Analysis {

    public BloodAnalysis() {
        doctorType = DoctorType.HEMATOLOGIST;
        appointmentDuration = 1000;
        price = 10;
    }

}
