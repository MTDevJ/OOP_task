package core.service.analysis;

import core.person.stuff.medical.DoctorType;
import core.service.MedicalService;

public abstract class Analysis implements MedicalService {

    protected Integer appointmentDuration;
    protected DoctorType doctorType;

    public Integer getAppointmentDuration() {
        return appointmentDuration;
    }

    public DoctorType getDoctorType() {
        return doctorType;
    }
}
