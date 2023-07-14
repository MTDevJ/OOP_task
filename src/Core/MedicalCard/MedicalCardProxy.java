package Core.MedicalCard;

import Core.Person.Patient;
import Core.Person.Stuff.Medical.MedicalStaff;
import Core.Person.Stuff.Staff;

public class MedicalCardProxy implements MedicalCardInterface{

    MedicalCard medicalCard;

    public MedicalCardProxy(MedicalCard medicalCard) {
        this.medicalCard = medicalCard;
    }

    @Override
    public void addRow(Staff person, Patient patient) {
        if (checkAccess(person)){
            medicalCard.addRow(person, patient);
        }
    }

    private Boolean checkAccess(Staff person){
        return (person instanceof MedicalStaff);//TODO and check if doctor support this procedure/test/
    }
}
