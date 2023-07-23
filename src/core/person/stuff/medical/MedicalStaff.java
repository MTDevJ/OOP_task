package core.person.stuff.medical;

import core.person.Patient;
import core.person.Person;
import core.person.stuff.Staff;
import core.person.stuff.medical.strategy.MedicalAppointmentStrategy;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public abstract class MedicalStaff extends Person implements Staff {

    MedicalAppointmentStrategy strategy;
    protected List<Type> supportedAnalysis = new ArrayList<>();
    protected List<Type> supportedExamination = new ArrayList<>();
    public abstract DoctorType getType();

    public String doAppointment(Patient patient){
        return strategy != null ? strategy.doAppointment(patient) : " not implemented yet";
    }

    public void setStrategy(MedicalAppointmentStrategy strategy) {
        this.strategy = strategy;
    }
}
