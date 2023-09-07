package core.medicalCard;

public class MedicalCardProxy implements MedicalCardInterface{

    MedicalCard medicalCard;

    public MedicalCardProxy(MedicalCard medicalCard) {
        this.medicalCard = medicalCard;
    }

    @Override
    public void addRecord(MedicalCardRecord record) {
        if (checkAccess(record)){
            medicalCard.addRecord(record);
        }
    }

    private Boolean checkAccess(MedicalCardRecord record){
        return ((record.cratedBy == record.appointmentResult.getAppointment().getDoctor()));
    }
}
