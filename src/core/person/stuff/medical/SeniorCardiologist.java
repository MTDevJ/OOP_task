package core.person.stuff.medical;

import core.person.Patient;
import core.person.stuff.medical.decorators.DoctorDecorator;

public class SeniorCardiologist extends DoctorDecorator {

    private final DoctorType TYPE = DoctorType.SENIOR_CARDIOLOGIST;
    public SeniorCardiologist(MedicalStaff staff) {
        super(staff);
    }

    @Override
    public DoctorType getType() {
        return this.TYPE;
    }

    @Override
    public String doAppointment(Patient patient) {
        if (patient.getClient().getAge() > 90){
            return "Heart disease";
        }
        return "Healthy";
    }
}
