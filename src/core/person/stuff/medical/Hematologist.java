package core.person.stuff.medical;

import core.person.Patient;
import core.service.analysis.BloodAnalysis;

public class Hematologist extends MedicalStaff {

    private final DoctorType TYPE = DoctorType.HEMATOLOGIST;

    public Hematologist() {
        super();
       supportedAnalysis.add(BloodAnalysis.class);
    }

    @Override
    public DoctorType getType() {
        return TYPE;
    }

    @Override
    public String doAppointment(Patient patient) {
        return null;
    }
}
