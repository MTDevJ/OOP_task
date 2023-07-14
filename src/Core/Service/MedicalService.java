package Core.Service;

import Core.Journal.ProxyJournal;
import Core.MedicalCard.MedicalCardProxy;
import Core.Person.Patient;
import Core.Person.Stuff.Staff;

public class MedicalService {

    public static void makeMedicalCardRecord(MedicalCardProxy medicalCard, Staff person, Patient patient){
        medicalCard.addRow(person, patient);
    }
}
