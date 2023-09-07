package core.person.stuff.medical;

import core.person.Patient;
import core.service.examination.HeartCheck;

public class Cardiologist extends MedicalStaff {

    private final DoctorType TYPE = DoctorType.CARDIOLOGIST;

    public Cardiologist() {
        super();
        supportedExamination.add(HeartCheck.class);
    }

    @Override
    public DoctorType getType() {
        return TYPE;
    }

    @Override
    public String doAppointment(Patient patient) {
        if(patient.getClient().getAge() > 70){
            return null;
        }
        return "Healthy";
    }
}

