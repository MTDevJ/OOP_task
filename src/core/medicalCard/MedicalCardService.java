package core.medicalCard;

import core.appointment.AppointmentResult;
import core.person.stuff.medical.MedicalStaff;

public class MedicalCardService {

    public static void makeMedicalCardRecord(MedicalCardProxy medicalCard, MedicalStaff person, AppointmentResult appointmentResult){
        medicalCard.addRecord(new MedicalCardRecord(person, appointmentResult));
    }
}
