package core.person.stuff.medical;

import core.appointment.AppointmentResult;
import core.medicalCard.MedicalCard;
import core.medicalCard.MedicalCardProxy;
import core.medicalCard.MedicalCardRecord;
import core.person.Patient;
import core.person.Person;
import core.person.stuff.Staff;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public abstract class MedicalStaff extends Person implements Staff {

    protected List<Type> supportedAnalysis = new ArrayList<>();
    protected List<Type> supportedExamination = new ArrayList<>();
    public abstract DoctorType getType();

    public abstract String doAppointment(Patient patient);

    public void makeMedicalCardRecord(MedicalCard medicalCard, MedicalStaff staff, AppointmentResult appointmentResult){
        new MedicalCardProxy(medicalCard).addRecord(new MedicalCardRecord(staff, appointmentResult));
    }

    public List<Type> getSupportedAnalysis() {
        return supportedAnalysis;
    }

    public List<Type> getSupportedExamination() {
        return supportedExamination;
    }
}
