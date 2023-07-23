package core.medicalCard;

import core.person.stuff.medical.MedicalStaff;
import core.person.stuff.Staff;

public class MedicalCardProxy implements MedicalCardInterface{

    MedicalCard medicalCard;

    public MedicalCardProxy(MedicalCard medicalCard) {
        this.medicalCard = medicalCard;
    }

    @Override
    public void addRecord(MedicalCardRecord record) {
        if (checkAccess(record.cratedBy)){
            medicalCard.addRecord(record);
        }
    }

    private Boolean checkAccess(Staff person){
        return (person instanceof MedicalStaff);//TODO and check if doctor support this procedure/test/
    }
}
